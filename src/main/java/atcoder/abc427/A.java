package atcoder.abc427;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(s.substring(0, s.length() / 2) + s.substring(s.length() / 2 + 1));
    }
}