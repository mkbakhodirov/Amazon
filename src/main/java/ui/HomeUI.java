package ui;


import model.user.User;
import response.Response;
import service.UsersService;

import java.util.Scanner;

public class HomeUI implements Response {

    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static void home() {
        WelcomeUI.enterance();
        boolean home = true;
        while (home) {
            System.out.println(SELECT);
            System.out.println("""
                    1.  REGISTER / LOGIN
                    2.  LOGIN AS ADMIN
                    0.  EXIT
                    """);
            switch (scannerInt.nextInt()) {
                case 1:
                    check();
                    break;
                case 2:
                    AdminUI();
                    break;
                case 0:
                    home = false;
                default:
                    System.out.println(INVALID_COMMAND);
            }
        }


    }

    public static void check() {
        User user = new User();
        UsersService userService = new UsersService();
        System.out.println(ENTER_PHONE);
        System.out.print(PHONE_BEGINNING);
        String replaced = scannerStr.nextLine().replace(" ", "");
        if (replaced.length() != 9) {
            System.out.println(INVALID_PHONE);
        } else {
            user.setPhoneNumber(replaced);
            if (userService.check(user) != null)
                userUI(user, userService);
            else {
                register(user, userService);
            }
        }
    }

    public static void register(User user, UsersService userService) {
        String password = "";
        boolean pass = false;
        while (!pass) {
            System.out.println(ENTER_PASSWORD);
            password = scannerStr.nextLine();

            System.out.println(ENTER_PASSWORD_AGAIN);
            if (!password.equals(scannerStr.nextLine())) {

                System.out.println(INCORRECT);
                System.out.println(WANT_GO_BEGINNING);
                if (scannerInt.nextInt() == 1)
                    home();
            } else pass = true;

        }
        user.setPassword(password);
        System.out.println(ENTER_NAME);
        user.setName(scannerStr.nextLine());
        userService.add(user, null);
        System.out.println(SUCCESS);
        System.out.println("\n" + CAN_LOGIN + "\n\n");

    }


    public static void userUI(User user, UsersService userService) {
        if (userService.checkPassword(user) == null)
            System.out.println(NOT_FOUND);
        else {
            boolean isActive = true;
            while (isActive) {
                System.out.println("""
                        1.
                        2.  
                        3.  
                        4.
                        5.
                        0.  Exit
                        """);
                switch (scannerInt.nextInt()) {
                    case 1:
                        break;
                    case 2:

                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0:
                        isActive = false;
                        break;
                    default:
                        System.out.println(INVALID_COMMAND);
                        break;
                }
            }
        }
    }

    public static void AdminUI() {

    }

}