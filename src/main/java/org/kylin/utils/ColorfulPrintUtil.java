package org.kylin.utils;

public class ColorfulPrintUtil {

    // ANSI 转义序列
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_COLOR_RED = "\u001B[31m";
    private static final String ANSI_COLOR_GREEN = "\u001B[32m";
    private static final String ANSI_COLOR_YELLOW = "\u001B[33m";
    private static final String ANSI_COLOR_BLUE = "\u001B[34m";
    private static final String ANSI_COLOR_MAGENTA = "\u001B[35m";
    private static final String ANSI_COLOR_CYAN = "\u001B[36m";
    private static final String ANSI_COLOR_WHITE = "\u001B[37m";

    // 红色文本
    public static void printRed(String text) {
        System.out.print(ANSI_COLOR_RED + text + ANSI_RESET);
    }
    public static void printlnRed(String text) {
        System.out.println(ANSI_COLOR_RED + text + ANSI_RESET);
    }
    // 绿色文本
    public static void printlnGreen(String text) {
        System.out.println(ANSI_COLOR_GREEN + text + ANSI_RESET);
    }
    public static void printGreen(String text) {
        System.out.print(ANSI_COLOR_GREEN + text + ANSI_RESET);
    }

    // 黄色文本
    public static void printYellow(String text) {
        System.out.print(ANSI_COLOR_YELLOW + text + ANSI_RESET);
    }
    public static void printlnYellow(String text) {
        System.out.println(ANSI_COLOR_YELLOW + text + ANSI_RESET);
    }

    // 蓝色文本
    public static void printlnBlue(String text) {
        System.out.println(ANSI_COLOR_BLUE + text + ANSI_RESET);
    }
    public static void printBlue(String text) {
        System.out.print(ANSI_COLOR_BLUE + text + ANSI_RESET);
    }
    // 洋红色文本
    public static void printMagenta(String text) {
        System.out.print(ANSI_COLOR_MAGENTA + text + ANSI_RESET);
    }
    public static void printlnMagenta(String text) {
        System.out.println(ANSI_COLOR_MAGENTA + text + ANSI_RESET);
    }
    // 青色文本
    public static void printCyan(String text) {
        System.out.print(ANSI_COLOR_CYAN + text + ANSI_RESET);
    }
    public static void printlnCyan(String text) {
        System.out.println(ANSI_COLOR_CYAN + text + ANSI_RESET);
    }
    // 白色文本
    public static void printlnWhite(String text) {
        System.out.println(ANSI_COLOR_WHITE + text + ANSI_RESET);
    }
    public static void printWhite(String text) {
        System.out.print(ANSI_COLOR_WHITE + text + ANSI_RESET);
    }

}
