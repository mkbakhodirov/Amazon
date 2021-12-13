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
    static UsersService usersService = new UsersService();
    static CategoriesService categoriesService = new CategoriesService();
    static ProductsService productsService = new ProductsService();

    public static void home() throws Exception {
        User admin = new User(UserRole.ADMIN, "123", "admin");
        usersService.add(admin);
        User user = new User(UserRole.USER, "123", "admin");
        usersService.add(user);
        List<User> users = usersService.read();
        User user1 = users.get(1);
        System.out.println(user1.getPhoneNumber());
        Category category = new Category("asd");
        categoriesService.add(category);
        User shop = new User("shop", UserRole.SHOP, "736", "123", "shop");
        usersService.add(shop);
        Product product = new Product(123, 1, shop.getId(), category.getId(), 1);
        productsService.add(product);
//        boolean stepcode = true;
//        while (stepcode) {
//            System.out.println(SELECT);
//            System.out.println("""
//                    1.Sign up
//                    2.Sign in
//                    0.Exit
//                    """);
//            switch (scannerInt.nextInt()) {
//                case 1:
//                    register();
//                    break;
//                case 2:
//                    adminUI();
//                    break;
//                case 0:
//                    stepcode = false;
//                    break;
//                default:
//                    System.out.println(INVALID_COMMAND);
//            }
//        }
    }

    private static void register() {
        System.out.println(ENTER_PHONE);

    }
    private static void adminUI() {

    }
}
