package ui;

import bot.bot_base.botLogic.MyBot;
import model.Category;
import model.response.Response;
import model.user.User;
import model.user.UserRole;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.CategoriesService;
import service.ProductsService;
import service.UsersService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
                case 4 -> System.out.println("Balance: " + superAdmin.getBalance());
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
        String res = usersService.add(UserRole.ADMIN, username, password);
        System.out.println(res);
    }

    private static void removeAdmin() {
        List<User> admins = usersService.getActiveAdmins();
        if (admins.isEmpty())
            System.out.println(EMPTY_LIST);
        else {
            int index = 1;
            System.out.println(SELECT);
            for (User admin : admins) {
                System.out.println(index++ + "." + admin.getUsername());
            }
            index = scannerInt.nextInt();
            if (index < 1 || index > admins.size())
                System.out.println(INVALID_COMMAND);
            else {
                User admin = admins.get(index - 1);
                System.out.println(usersService.remove(admin.getId()));
            }
        }
    }

    private static void seeAdmins() {
        List<User> admins = usersService.getAdmins();
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
                    3.See users
                    4.Remove user
                    0.Exit
                    """);
            switch (scannerInt.nextInt()) {
                case 1 -> addCategory();
                case 2 -> removeCategory();
                case 3 -> seeUsers();
                case 4 -> removeUser();
                case 0 -> stepcode = false;
                default -> System.out.println(INVALID_COMMAND);
            }
        }
    }

    private static void addCategory() {
        boolean stepCode = true;
        while (stepCode) {
            List<Category> categories = categoriesService.getMainCategories();
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
                String res = categoriesService.add(name);
                System.out.println(res);
            }
            else if (index1 == 0)
                stepCode = false;
            else if (index1 > 0 && index1 <= index - 1) {
                Category category = categories.get(index1 - 1);
                addSubcategory(category.getId());
            }
            else
                System.out.println(INVALID_COMMAND);
        }
    }

    private static void addSubcategory(UUID parentCategoryId) {
        List<Category> categories = categoriesService.getSubcategories(parentCategoryId);
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
            String res = categoriesService.add(name, parentCategoryId);
            System.out.println(res);
        }
        else if (index1 > 0 && index1 <= index - 1) {
            Category category = categories.get(index1 - 1);
            addSubcategory(category.getId());
        }
        else if (index1 != 0)
            System.out.println(INVALID_COMMAND);
    }

    private static void removeCategory() {
        boolean stepCode = true;
        while (stepCode) {
            List<Category> categories = categoriesService.getMainCategories();
            int index = 1;
            if (categories.isEmpty()) {
                System.out.println(EMPTY_LIST);
                return;
            }
            System.out.println(SELECT);
            for (Category category : categories) {
                System.out.println(index++ + "." + category.getName());
            }
            System.out.println(index + ".Remove\t 0.Exit");
            int index1 = scannerInt.nextInt();
            if (index1 == index) {
                System.out.println(ENTER_INDEX);
                index1 = scannerInt.nextInt();
                if (index1 > 0 && index1 <= index - 1) {
                    Category category = categories.get(index1 - 1);
                    String res = categoriesService.remove(category.getId());
                    System.out.println(res);
                }
                else
                    System.out.println(INVALID_COMMAND);
            }
            else if (index1 == 0)
                stepCode = false;
            else if (index1 > 0 && index1 <= index - 1) {
                Category category = categories.get(index1 - 1);
                removeSubcategory(category.getId());
            }
            else
                System.out.println(INVALID_COMMAND);
        }
    }

    private static void removeSubcategory(UUID parentCategoryId) {
        List<Category> categories = categoriesService.getSubcategories(parentCategoryId);
        int index = 1;
        if (categories.isEmpty()) {
            System.out.println(EMPTY_LIST);
            return;
        }
        System.out.println(SELECT);
        for (Category category : categories) {
            System.out.println(index++ + "." + category.getName());
        }
        System.out.println(index + ".Remove\t 0.Exit");
        int index1 = scannerInt.nextInt();
        if (index1 == index) {
            System.out.println(ENTER_INDEX);
            index1 = scannerInt.nextInt();
            if (index1 > 0 && index1 <= index - 1) {
                Category category = categories.get(index1 - 1);
                String res = categoriesService.remove(category.getId());
                System.out.println(res);
            }
            else
                System.out.println(INVALID_COMMAND);
        }
        else if (index1 > 0 && index1 <= index - 1) {
            Category category = categories.get(index1 - 1);
            removeSubcategory(category.getId());
        }
        else if (index1 != 0)
            System.out.println(INVALID_COMMAND);
    }

    private static void seeUsers() {
        List<User> users = usersService.getUsers();
        if (users.isEmpty()) {
            System.out.println(EMPTY_LIST);
        }
        for (User user : users) {
            System.out.println("ID: " + user.getId() + " ChatId: " + user.getChatId() + " Active: " + user.isActive());
        }
    }

    private static void removeUser() {
        String uuid = scannerStr.next();
        String res = usersService.remove(uuid);
        System.out.println(res);
    }
}
