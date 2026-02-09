package atcoder.abc444;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if(str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}