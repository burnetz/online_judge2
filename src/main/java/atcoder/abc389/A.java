package atcoder.abc389;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int a = Integer.parseInt(str.substring(0, 1));
        int b = Integer.parseInt(str.substring(2, 3));

        System.out.println(a * b);
    }
}