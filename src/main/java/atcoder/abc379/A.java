package atcoder.abc379;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        System.out.println(n.substring(1) + n.charAt(0) + " " + n.charAt(2) + n.substring(0, 2));
    }
}