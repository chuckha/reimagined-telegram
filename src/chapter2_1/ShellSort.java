package chapter2_1;

import java.util.Scanner;

public class ShellSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void sort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    System.out.printf("i: %s j: %s h: %s\n", i, j, h);
                    for (int k=0; k< N; k++) {
                        if (k == j) {
                            red(a[k].toString());
                        } else if (k == j-h) {
                            blue(a[k].toString());
                        } else if (k == h) {
                            green(a[k].toString());
                        } else if (k == i) {
                            cyan(a[k].toString());
                        } else {
                            System.out.printf("%s ", a[k]);
                        }
                    }
                    System.out.println();
                    exch(a, j, j - h);
                }
            }
            h = h/3; }
    }
    private static void red(String s) {
        System.out.printf("%s%s%s ", ANSI_RED, s, ANSI_RESET);
    }
    private static void purple(String s) {
        System.out.printf("%s%s%s ", ANSI_PURPLE, s, ANSI_RESET);
    }
    private static void green(String s) {
        System.out.printf("%s%s%s ", ANSI_GREEN, s, ANSI_RESET);
    }
    private static void blue(String s) {
        System.out.printf("%s%s%s ", ANSI_BLUE, s, ANSI_RESET);
    }
    private static void cyan(String s) {
        System.out.printf("%s%s%s ", ANSI_CYAN, s, ANSI_RESET);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.printf("%s ", item);
        }
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String item = stdin.nextLine().trim();
        String[] items = item.split(" ");
        sort(items);
        show(items);
    }
}
