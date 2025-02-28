package atcoder.abc394;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(str.replaceAll("[0,1,3-9]", ""));
    }
}