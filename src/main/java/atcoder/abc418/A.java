package atcoder.abc418;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();

        System.out.println(s.matches(".*tea") ? "Yes" : "No");
    }
}