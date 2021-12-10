package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Category;
import model.Product;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class ProductsService implements BaseService<Product, Category, List<Product>> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "product")
    private final List<Product> products = new ArrayList<>();

    @Override
    public String add(Product product) {
        products.add(product);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("C:\\D\\PDP\\Java Backend FAANG\\Amazon\\src\\main\\java\\Database\\users.json");
            objectMapper.writeValue(file, products);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return SUCCESS;
    }

    @Override
    public String remove(Product product) {
        product.setActive(false);
        return SUCCESS;
    }

    @Override
    public String edit(Product product) {
        return null;
    }

    @Override
    public Product get(String str1, String str2) {
        return null;
    }

    @Override
    public Product getByIndex(int index) {
        return null;
    }

    @Override
    public List<Product> getList(Category category) {
        List<Product> productsOfCategory = new ArrayList<>();
        UUID categoryId = category.getId();
        for (Product product : products) {
            if (product.isActive() && product.getCategoryId().equals(categoryId))
                productsOfCategory.add(product);
        }
        return productsOfCategory;
    }

    @Override
    public List<Product> getList() {
        return null;
    }

    @Override
    public Product check(String username, String password) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
}
