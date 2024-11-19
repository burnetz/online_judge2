package atcoder.abc380;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        char[] cArray = n.toCharArray();
        Arrays.sort(cArray);

        System.out.println(new String(cArray).equals("122333") ? "Yes" : "No");
    }
}