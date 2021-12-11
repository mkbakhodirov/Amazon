package service;

import Database.BaseUrl;
import model.Category;
import service.base.BaseService;

import java.io.File;
import java.util.List;

public class CategoriesService implements BaseService<Category, Category, List<Category>> {
    static File file = new File(BaseUrl.url + "categories.json");

    @Override
    public String add(Category category) {
        return null;
    }

    @Override
    public String remove(Category category) {
        return null;
    }

    @Override
    public int check(Category category, List<Category> list) {
        return 0;
    }

    @Override
    public Category get(String str1, String str2) {
        return null;
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
