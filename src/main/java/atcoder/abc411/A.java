package atcoder.abc411;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String p = sc.next();
        int l = sc.nextInt();

        System.out.println(p.length() >= l ? "Yes" : "No");
    }
}