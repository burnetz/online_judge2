package atcoder.abc423;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(x / (1000 + c) * 1000);
    }
}