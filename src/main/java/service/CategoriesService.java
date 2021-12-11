package service;

import Database.BaseUrl;
import model.Category;
import model.Product;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CategoriesService implements BaseService<Category, Category, List<Category>> {
    static File file = new File(BaseUrl.url + "categories.json");

    @Override
    public String add(Category category) {
        List<Category> categories = read(file);
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
        return null;
    }

    @Override
    public List<Category> getList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
