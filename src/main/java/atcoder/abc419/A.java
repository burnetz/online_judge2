package atcoder.abc419;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        switch (s) {
            case "red" -> {
                System.out.println("SSS");
            }
            case "green" -> {
                System.out.println("MMM");
            }
            case "blue" -> {
                System.out.println("FFF");
            }
            default -> {
                System.out.println("Unknown");
            }
        }
    }
}