package atcoder.abc459;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = "HelloWorld";

        System.out.println(str.substring(0, n - 1) + str.substring(n));
    }
}