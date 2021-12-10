package ui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import model.response.Response;
import model.user.User;
import model.user.UserRole;
import service.ProductsService;
import service.UsersService;
import model.user.User;
import model.user.UserRole;
import service.ProductsService;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HomeUI implements Response {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static UsersService usersService;
    static User user;

    public static void home() throws Exception {
        ProductsService productsService = new ProductsService();
        User user = new User(UserRole.SHOP, "736", "123", "456");
        User user1 = new User(UserRole.SHOP, "123", "123", "123");
        Date date = new Date();
        Product product = new Product(100, 1, user1.getId(), user.getId(), date);

        productsService.add(product);
        File file = new File("C:\\D\\PDP\\Java Backend FAANG\\Amazon\\src\\main\\java\\Database\\users.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = objectMapper.readValue(file, new TypeReference<List<Product>>() {});
        System.out.println(products.get(0));
        WelcomeUI.entrance();
        boolean stepcode1 = true;
        while (stepcode1) {
            System.out.println(SELECT);
            System.out.println("""
                    1. Register
                    2.Sign in as Admin
                    0.Exit
                    """);
            switch (scannerInt.nextInt()){
                case 1:
                    register();
                    break;
                case 2:
                    adminUI();
                    break;
                case 0:
                    stepcode1 = false;
                    break;
                default:
                    System.out.println(INVALID_COMMAND);
            }
        }
    }

    private static void register() {

    }
    private static void adminUI() {

    }
}
