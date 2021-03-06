package service;

import com.fasterxml.jackson.core.type.TypeReference;
import database.BaseUrl;
import model.Product;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductsService implements BaseService<Product, List<Product>> {
    static File file = new File(BaseUrl.url + "products.json");

    public String add(String name, String priceStr, String amountStr, String userIdStr, String categoryIdStr) {
        double price;
        int amount;
        UUID userId;
        UUID categoryId;

        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            return e.getMessage();
        }

        try {
            amount = Integer.parseInt(amountStr);
        } catch (Exception e) {
            return e.getMessage();
        }

        try {
            userId = UUID.fromString(userIdStr);
        } catch (Exception e) {
            return e.getMessage();
        }

        try {
            categoryId = UUID.fromString(categoryIdStr);
        } catch (Exception e) {
            return e.getMessage();
        }

        return add(name, price, amount, userId, categoryId);
    }

    public String add(String name, double price, int amount, UUID userId, UUID categoryId) {
        List<Product> products = getList();
        boolean isValidName = check(name, products);
        if (isValidName) {
            Product product = new Product(name, price, amount, userId, categoryId);
            add(product, products);
            write(file, products);
            return SUCCESS;
        }
        return INVALID_PRODUCT;
    }

    @Override
    public void add(Product product, List<Product> products) {
        products.add(product);
    }

    @Override
    public String remove(String uuid) {
        UUID id = UUID.fromString(uuid);
        return remove(id);
    }

    @Override
    public String remove(UUID id) {
        List<Product> products = getList();
        Product product = get(id, products);
        if (product != null) {
            boolean isSuccess = remove(product, products);
            if (isSuccess) {
                write(file, products);
                return SUCCESS;
            } else
                return PRODUCT_ALREADY_REMOVED;
        }

        return NOT_FOUND;
    }

    @Override
    public boolean remove(Product product, List<Product> products) {
        if (product.isActive()) {
            product.setActive(false);
            return true;
        }
        return false;
    }

    @Override
    public String editName(String uuid, String name) {
        UUID id = UUID.fromString(uuid);
        return editName(id, name);
    }

    @Override
    public String editName(UUID id, String name) {
        List<Product> products = getList();
        Product product = get(id, products);
        if (product != null) {
            boolean isSuccess = editName(product, name);
            if (isSuccess)
                return SUCCESS;
            else
                return SAME_NAME;
        }
        return NOT_FOUND;
    }

    @Override
    public boolean editName(Product product, String name) {
        if (product.getName().equals(name))
            return false;
        product.setName(name);
        return true;
    }

    @Override
    public boolean check(String name, List<Product> products) {
        for (Product product : products) {
            if (product.getName().equals(name))
                return false;
        }
        return true;
    }

    @Override
    public Product get(String uuid) {
        UUID id = UUID.fromString(uuid);
        return get(id);
    }

    @Override
    public Product get(UUID id) {
        List<Product> products = getList();
        return get(id, products);
    }

    @Override
    public Product get(UUID id, List<Product> products) {
        for (Product product : products) {
            if (product.getId().equals(id))
                return product;
        }
        return null;
    }

    @Override
    public List<Product> read() {
        try {
            return obj.readValue(file, new TypeReference<>() {
            });
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Product> getActiveList() {
        List<Product> activeProducts = new ArrayList<>();
        for (Product product : getList())
            if (product.isActive())
                activeProducts.add(product);
        return activeProducts;
    }

    public List<Product> getProducts(String categoryId) {
        List<Product> products = new ArrayList<>();
        for (Product product : getActiveList())
            if (product.getCategoryId().equals(categoryId))
                products.add(product);
        return products;
    }
}
