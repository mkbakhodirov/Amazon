package ui;

import Database.BaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Category;
import model.Product;
import model.response.Response;
import model.user.User;
import model.user.UserRole;
import service.CategoriesService;
import service.ProductsService;
import service.UsersService;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HomeUI implements Response {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerLine = new Scanner(System.in);
    static UsersService usersService = new UsersService();
    static CategoriesService categoriesService = new CategoriesService();
    static ProductsService productsService = new ProductsService();

    public static void home() throws Exception {

        boolean stepcode = true;
        while (stepcode) {
            System.out.println(SELECT);
            System.out.println("""
                    1.Sign in
                    0.Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> signIn();
                case 0 -> stepcode = false;
                default -> System.out.println(INVALID_COMMAND);
            }
        }
    }

    private static void signIn() {
        System.out.println(ENTER_USERNAME);
        String username = scannerStr.next();
        System.out.println(ENTER_PASSWORD);
        String password = scannerStr.next();
        User admin = usersService.get(username, password);
        if (admin != null) {
            if (admin.getRole().equals(UserRole.SUPER_ADMIN))
                superAdminUI(admin);
            else if (admin.getRole().equals(UserRole.ADMIN))
                adminUI(admin);
        }
        else
            System.out.println(INCORRECT_ADMIN);
    }

    private static void superAdminUI(User superAdmin) {
        boolean stepcode = true;
        while (stepcode) {
            System.out.println(SELECT);
            System.out.println("""
                    1.Add admin
                    2.Remove admin
                    3.See admins
                    4.See balance
                    0.Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> addAdmin();
                case 2 -> removeAdmin();
                case 3 -> seeAdmins();
                case 0 -> stepcode = false;
                default -> System.out.println(INVALID_COMMAND);
            }
        }
    }

    private static void addAdmin() {
        System.out.println(ENTER_USERNAME);
        String username = scannerStr.next();
        System.out.println(ENTER_PASSWORD);
        String password = scannerStr.next();
        User admin = new User(UserRole.ADMIN, username, password);
        String res = usersService.add(admin);
        if (res != null)
            System.out.println(res);
    }

    private static void removeAdmin() {
        List<User> admins = usersService.getActiveAdminsList();
        if (admins.isEmpty())
            System.out.println(EMPTY_LIST);
        else {
            int index = 1;
            System.out.println(SELECT);
            for (User admin : admins) {
                System.out.println(index++ + "." + admin.getUsername());
            }
            index = scannerInt.nextInt();
            User admin = admins.get(index - 1);
            System.out.println(usersService.remove(admin));
        }
    }

    private static void seeAdmins() {
        List<User> admins = usersService.getAdminsList();
        if (admins.isEmpty())
            System.out.println(EMPTY_LIST);
        else {
            int index = 1;
            for (User admin : admins) {
                System.out.println(index++ + "." + "ID: " + admin.getId() + " Username: " + admin.getUsername() +
                        " Password: " + admin.getPassword() + " Active: " + admin.isActive());
            }
        }
    }

    private static void adminUI(User admin) {
        boolean stepcode = true;
        while (stepcode) {
            System.out.println(SELECT);
            System.out.println("""
                    1.Add category
                    2.Remove category
                    0.Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> addCategory();
                case 2 -> removeCategory();
                case 0 -> stepcode = false;
                default -> System.out.println(INVALID_COMMAND);
            }
        }
    }

    private static void addCategory() {
        boolean stepCode = true;
        while (stepCode) {
            List<Category> categories = categoriesService.getList();
            int index = 1;
            System.out.println(SELECT);
            for (Category category : categories) {
                System.out.println(index++ + "." + category.getName());
            }
            System.out.println(index + ".Add\t 0.Exit");
            int index1 = scannerInt.nextInt();
            if (index1 == index) {
                System.out.println(ENTER_NAME);
                String name = scannerLine.nextLine();
                Category category = new Category(name);
                String res = categoriesService.add(category);
                if (res != null)
                    System.out.println(res);
            }
            else if (index1 == 0)
                stepCode = false;
            else {
                Category category = categories.get(index1 - 1);
                addSubcategory(category);
            }
        }
    }

    private static void addSubcategory(Category category) {
        List<Category> categories = categoriesService.getList(category);
        int index = 1;
        System.out.println(SELECT);
        for (Category category1 : categories) {
            System.out.println(index++ + "." + category1.getName());
        }
        System.out.println(index + ".Add\t 0.Exit");
        int index1 = scannerInt.nextInt();
        if (index1 == index) {
            System.out.println(ENTER_NAME);
            String name = scannerLine.nextLine();
            Category category1 = new Category(name, category.getId());
            String res = categoriesService.add(category1);
            if (res != null) {
                System.out.println(res);
                if (category.isLastCategory())
                    category.setLastCategory(false);
            }
        }
        else if (index1 != 0) {
            Category category1 = categories.get(index1 - 1);
            addSubcategory(category1);
        }
    }

    private static void removeCategory() {
        boolean stepCode = true;
        while (stepCode) {
            List<Category> categories = categoriesService.getList();
            int index = 1;
            System.out.println(SELECT);
            for (Category category : categories) {
                System.out.println(index++ + "." + category.getName());
            }
            System.out.println(index + ".Remove\t 0.Exit");
            int index1 = scannerInt.nextInt();
            if (index1 == index) {
                System.out.println("Enter index");
                int index2 = scannerInt.nextInt();
                Category category = categories.get(index2 - 1);
                String res = categoriesService.remove(category);
                if (res != null)
                    System.out.println(res);
            }
            else if (index1 == 0)
                stepCode = false;
            else {
                Category category = categories.get(index1 - 1);
                addSubcategory(category);
            }
        }
    }

    private static void removeSubcategory(Category category) {
        List<Category> categories = categoriesService.getList(category);
        int index = 1;
        System.out.println(SELECT);
        for (Category category1 : categories) {
            System.out.println(index++ + "." + category1.getName());
        }
        System.out.println(index + ".Remove\t 0.Exit");
        int index1 = scannerInt.nextInt();
        if (index1 == index) {
            System.out.println("Enter index");
            int index2 = scannerInt.nextInt();
            Category category1 = categories.get(index2 - 1);
            String res = categoriesService.remove(category1);
            if (res != null)
                System.out.println(res);
                List<Category> categoryList = categoriesService.getList(category);
                for (Category category2 : categoryList) {
                    if (category2.isActive())
                        return;
                }
                category.setLastCategory(true);
        }
        else if (index1 != 0) {
            Category category1 = categories.get(index1 - 1);
            addSubcategory(category1);
        }
    }

}
