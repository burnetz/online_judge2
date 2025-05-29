package atcoder.arc198;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        }

        System.out.println(n / 2);
        for(int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
        }
    }
}
