package service;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Category;
import model.Product;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoriesService implements BaseService<Category, Category, List<Category>> {
    static File file = new File(BaseUrl.url + "categories.json");

    @Override
    public String add(Category category) {
        List<Category> categories = read();
        if (categories == null)
            categories = new ArrayList<>();
        int res = check(category, categories);
        if (res == 1) {
            categories.add(category);
            write(file, categories);
            return SUCCESS;
        }
        else if (res == -1)
            return INVALID_CATEGORY;
        return null;
    }

    @Override
    public String remove(Category category) {
        return null;
    }

    @Override
    public int check(Category category, List<Category> categories) {
        String name = category.getName();
        for (Category category1 : categories) {
            if (category1.getName().equals(name))
                return -1;
            if (category1.equals(category))
                return 0;
        }
        return 1;
    }

    @Override
    public Category getByIndex(int index) {
        return null;
    }

    @Override
    public List<Category> getList(Category category) {
        UUID categoryId = category.getId();
        List<Category> categories = read();
        List<Category> subCategories = new ArrayList<>();
        if (categories != null) {
            for (Category category1 : categories) {
                if (category1.getParentId().equals(categoryId))
                    subCategories.add(category1);
            }
        }
        return subCategories;
    }

    @Override
    public List<Category> getList() {
        List<Category> categories = read();
        List<Category> mainCategories = new ArrayList<>();
        if (categories != null) {
            for (Category category : categories) {
                if (category.getParentId() == null)
                    mainCategories.add(category);
            }
        }
        return mainCategories;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public List<Category> read() {
        try {
            return new ObjectMapper().readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return null;
        }
    }

}
