package ui;


import model.user.User;
import response.Response;
import service.UsersService;

import java.util.Scanner;

public class HomeUI implements Response {
//   History history = new History();

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
//                case 2:
//                    userUI();
//                    break;
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

    public static void register(User user, UserService userService) {
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


    public static void userUI(User user, UserService userService) {
        BookService bookService = new BookService();
        Book book = new Book();
        HistoryService historyService = new HistoryService();
        if (userService.checkPassword(user) == null)
            System.out.println(NOT_FOUND);
        else {
            boolean isActive = true;
            while (isActive) {
                System.out.println("""
                        1.  Books you have checked
                        2.  Waiting List
                        3.  Loan History
                        4.  Currently  reading
                        5.  Already read
                        6.  My notes
                        7.  My reviews
                        8.  Borrow a book(up to 10 books in a month)
                        9.  Buy a book
                        10. Search a book
                        11. Donate
                        12. 
                        0.  Exit
                        """);
                switch (scannerInt.nextInt()) {
                    case 1:
                        book.setName(scannerStr.nextLine());
                        Book checkedBook = bookService.check(book);
                        if (checkedBook == null)
                            System.out.println(NOT_AVAILABLE);
                        else {
                            System.out.println(WANT_TAKE);
                            if (scannerInt.nextInt() == 1) {
                                historyService.add(book, user);
                            }
                        }
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
