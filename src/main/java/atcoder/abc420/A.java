package atcoder.abc420;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt() - 1;
        int y = sc.nextInt();

        System.out.println((x + y) % 12 + 1);
    }
}