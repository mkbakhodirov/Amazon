package service;

import Database.BaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Category;
import model.Product;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ProductsService implements BaseService<Product, Category, List<Product>> {
    static File file = new File(BaseUrl.url + "products.json");

    @Override
    public String add(Product product) {
        List<Product> products = read(file);
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
        return null;
    }

    @Override
    public List<Product> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
