package uz.pdp.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;3;34m";    // BLUE
    public static final String BLUE_ITALIC_CROSSED_OUT_BOLD = "\033[0;3;9;1;34m";    // BLUE_ITALIC_CROSSED_OUT_BOLD
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String RED_CROSSED_OUT = "\033[9;31m";    // RED_CROSSED_OUT
    public static final String RED_CROSSED_OUT_ITALIC = "\033[9,3;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String CYAN_CROSSED_OUT = "\033[9;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE


    public static void print(String color, String str) {
        System.out.println(color + str + RESET);
    }

    public static void print(String color, String str, boolean isCrossedOut) {
        if (isCrossedOut) {
            String start = color.substring(0, 4); // \033[
            String end = color.substring(4); // 9;31m
            String result = start + "9;" + end;
            System.out.println(result + str + RESET);
            return;
        }
        System.out.println(color + str + RESET);
    }

    public static void print(Object str, boolean isCrossedOut) {
        if (isCrossedOut) {
            System.out.println("\033[0;9;30m" + str + RESET);
            return;
        }
        System.out.println(str);
    }

    public static void print(Object str) {
        System.out.println(str);
    }

    public static void printInRed(String str) {
        System.out.println(RED_BRIGHT + str + RESET);
    }


    public static String inputStr() {
        Scanner scannerStr = new Scanner(System.in);
        try {
            return scannerStr.nextLine();
        } catch (InputMismatchException e) {
            printInRed("Error ! Input string please");
        }
        return inputStr();
    }

    public static int inputInt() {
        Scanner scannerInt = new Scanner(System.in);
        try {
            return scannerInt.nextInt();
        } catch (InputMismatchException e) {
            Util.printInRed("Error! Input number please!!!");
            scannerInt.nextLine();
        }
        return inputInt();
    }

    public static double inputDouble() {
        Scanner scannerDou = new Scanner(System.in);
        try {
            return scannerDou.nextDouble();
        } catch (InputMismatchException e) {
            Util.printInRed("Error! Input number please!!!");
            scannerDou.nextLine();
        }
        return inputDouble();
    }


}
