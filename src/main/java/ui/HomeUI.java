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
