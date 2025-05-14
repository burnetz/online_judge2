package atcoder.abc398;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] str = new char[n];
        Arrays.fill(str, '-');

        if(n % 2 == 0) {
            str[n/2 - 1] = '=';
            str[n/2] = '=';
        }
        else {
            str[n/2] = '=';
        }

        System.out.println(str);
    }
}