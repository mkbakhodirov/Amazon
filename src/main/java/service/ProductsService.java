package service;

import database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Category;
import model.Product;
import model.history.HistoryShop;
import model.history.HistoryUser;
import model.user.User;
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
        }
    }

    @Override
    public void add(Product product, List<Product> products) {
        products.add(product);
    }

    @Override
    public String remove(String uuid) {
        return null;
    }

    @Override
    public String remove(UUID id) {
        return null;
    }

    @Override
    public boolean remove(Product product, List<Product> list) {
        return false;
    }

    @Override
    public String editName(String uuid, String name) {
        return null;
    }

    @Override
    public String editName(UUID id, String name) {
        return null;
    }

    @Override
    public boolean editName(Product product, String name) {
        return false;
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
        return null;
    }

    @Override
    public Product get(UUID id) {
        return null;
    }

    @Override
    public Product get(UUID id, List<Product> list) {
        return null;
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public List<Product> getActiveList() {
        return null;
    }
}
