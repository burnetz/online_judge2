package atcoder.abc370;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt() * 2;
        int r = sc.nextInt();

        switch (l + r) {
            case 0, 3 -> {
                System.out.println("Invalid");
            }
            case 1 -> {
                System.out.printf("No");
            }
            default -> {
                System.out.printf("Yes");
            }
        }
    }
}