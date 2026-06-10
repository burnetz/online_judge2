package atcoder.abc460;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        while(m != 0) {
            m = n % m;
            count++;
        }

        System.out.println(count);
    }
}