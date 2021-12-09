package ui;

import model.response.Response;

import java.util.Scanner;

public class HomeUI implements Response {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static void home() {
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
