package atcoder.abc442;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.next().toCharArray();
        int count = 0;
        for (char c : s) {
            if (c == 'i' || c == 'j') {
                count++;
            }
        }

        System.out.println(count);

    }
}