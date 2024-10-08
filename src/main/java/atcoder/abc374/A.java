package atcoder.abc374;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(str.matches(".*san") ? "Yes" : "No");
    }
}