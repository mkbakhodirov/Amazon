package service;

import database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import model.Category;
import service.base.BaseService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoriesService implements BaseService<Category, List<Category>> {
    static File file = new File(BaseUrl.url + "categories.json");

    public String add(String name) {
        List<Category> categories = read();
        boolean isValidName = check(name, categories);
        if (isValidName) {
            Category category = new Category(name);
            add(category, categories);
            write(file, categories);
            return SUCCESS;
        }
        return "Invalid name";
    }

    public String add(String name, String parentUUID) {
        UUID parentId = UUID.fromString(parentUUID);
        return add(name, parentId);
    }

    public String add(String name, UUID parentId) {
        List<Category> categories = read();
        boolean isValidName = check(name, categories);
        if (isValidName) {
            Category category = new Category(name, parentId);
            add(category, categories);
            write(file, categories);
            return "Success";
        }
        return "Invalid name";
    }

    @Override
    public void add(Category category, List<Category> categories) {
        categories.add(category);
        UUID parentId = category.getParentId();
        if (parentId != null) {
            Category parentCategory = get(category.getParentId(), categories);
            parentCategory.setLastSubcategory(false);
        }
    }

    @Override
    public String remove(String uuid) {
        UUID id = UUID.fromString(uuid);
        return remove(id);
    }

    @Override
    public String remove(UUID id) {
        List<Category> categories = read();
        Category category = get(id, categories);
        boolean isSuccess = remove(category, categories);
        if (isSuccess) {
            write(file, categories);
            return "Success";
        }
        return "Category was removed early";
    }

    @Override
    public boolean remove(Category category, List<Category> categories) {
        if (category.isActive()) {
            category.setActive(false);
            List<Category> subcategories = getSubcategories(category.getParentId(), categories);
            if (subcategories.isEmpty()) {
                System.out.println(123);
                Category parentCategory = get(category.getParentId(), categories);
                parentCategory.setLastSubcategory(true);
            }
            return true;
        }
        return false;
    }

    public String editName(String uuid, String name) {
        UUID id = UUID.fromString(uuid);
        return editName(id, name);
    }

    public String editName(UUID id, String name) {
        List<Category> categories = read();
        Category category = get(id, categories);
        boolean isSuccess = editName(category, name);
        if (isSuccess) {
            write(file, categories);
            return SUCCESS;
        }
        return SAME_NAME;
    }

    public boolean editName(Category category, String name) {
        if (category.getName().equals(name))
            return false;
        category.setName(name);
        return true;
    }

    @Override
    public boolean check(String name, List<Category> categories) {
        for (Category category : categories) {
            if (category.isActive() && category.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Category get(String uuid) {
        UUID id = UUID.fromString(uuid);
        return get(id);
    }

    @Override
    public Category get(UUID id) {
        List<Category> categories = read();
        for (Category category : categories) {
            if (category.getId().equals(id))
                return category;
        }
        return null;
    }

    @Override
    public Category get(UUID id, List<Category> categories) {
        for (Category category : categories) {
            if (category.getId().equals(id))
                return category;
        }
        return null;
    }

    @Override
    public List<Category> read() {
        try {
            return obj.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Category> getActiveList() {
        List<Category> activeCategories = new ArrayList<>();
        for (Category category : getList()) {
            if (category.isActive())
                activeCategories.add(category);
        }
        return activeCategories;
    }

    public List<Category> getMainCategories() {
        List<Category> categories = read();
        List<Category> mainCategories = new ArrayList<>();
        for (Category category : categories) {
            if (category.isActive() && category.getParentId() == null) {
                mainCategories.add(category);
            }
        }
        return mainCategories;
    }

    public List<Category> getSubcategories(String parentUUID) {
        UUID parentId = UUID.fromString(parentUUID);
        return getSubcategories(parentId);
    }

    public List<Category> getSubcategories(UUID parentId) {
        List<Category> categories = read();
        List<Category> subcategories = new ArrayList<>();
        for (Category category : categories) {
            if (category.isActive() && category.getParentId() != null && category.getParentId().equals(parentId))
                subcategories.add(category);
        }
        return subcategories;
    }

    public List<Category> getSubcategories(UUID parentId, List<Category> categories) {
        List<Category> subcategories = new ArrayList<>();
        for (Category category : categories) {
            if (category.isActive() && category.getParentId() != null && category.getParentId().equals(parentId))
                subcategories.add(category);
        }
        return subcategories;
    }
}