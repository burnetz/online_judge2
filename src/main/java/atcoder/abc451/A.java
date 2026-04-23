package atcoder.abc451;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(s.length() % 5 == 0 ? "Yes" : "No");
    }
}