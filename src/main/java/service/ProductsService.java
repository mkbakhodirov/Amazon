package service;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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

public class ProductsService implements BaseService<Product, Category, List<Product>> {
    static File file = new File(BaseUrl.url + "products.json");

    @Override
    public String add(Product product) {
        List<Product> products = read();
        if (products == null)
            products = new ArrayList<>();
        int res = check(product, products);
        if (res == 1) {
            products.add(product);
            write(file, products);
            return SUCCESS;
        }
        else if (res == -1)
            return INVALID_PRODUCT;
        return null;
    }

    @Override
    public String remove(Product product) {
        return null;
    }

    @Override
    public int check(Product product, List<Product> products) {
        String name = product.getName();
        for (Product product1 : products) {
            if (product1.getName().equals(name))
                return -1;
            if (product1.equals(product))
                return 0;
        }
        return 1;
    }

    @Override
    public Product getByIndex(int index) {
        return null;
    }

    @Override
    public List<Product> getList(Category category) {
        UUID categoryId = category.getId();
        List<Product> products = read();
        List<Product> productsOfCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategoryId().equals(categoryId))
                productsOfCategory.add(product);
        }
        return productsOfCategory;
    }

    @Override
    public List<Product> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public List<Product> read() {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }

    public String order(Product product, User user, int amount) {
        if (amount < 1)
            return "Enter positive number";
        if (product.getAmount() < 1)
            return "There is not a product";
        else if (product.getAmount() < amount)
            return "Product amount is not enough";
        else {
            int amount1 = product.getAmount() - amount;
            product.setAmount(amount1);
            double balanceUser = user.getBalance() - product.getPrice() * amount;
            if (balanceUser < 0)
                return "Balance is not enough";
            else {
                HistoriesService historiesService = new HistoriesService();
                User shop = new UsersService().getById(product.getShopId());
                HistoryUser historyUser = new HistoryUser(product.getName(), shop.getName(), product.getPrice(), amount, user.getId());
                int res = historiesService.check(historyUser, historiesService.read());
                if (res == 1) {
                    double balanceShop = shop.getBalance() + product.getPrice() * amount;
                    shop.setBalance(balanceShop);
                    user.setBalance(balanceUser);
                    HistoryShop historyShop = new HistoryShop(product.getName(), product.getPrice(), amount, user.getName(), shop.getId());
                    historiesService.add(historyShop);
                    historiesService.add(historyUser);
                    return SUCCESS;
                }
                return null;
            }
        }
    }
}
