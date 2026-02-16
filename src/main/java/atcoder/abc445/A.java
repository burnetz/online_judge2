package atcoder.abc445;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}