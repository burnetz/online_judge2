package atcoder.abc425;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long result = 0;

        for(int i = 1; i <= n; i++) {
            result += Math.pow(-1, i) * Math.pow(i, 3);
        }

        System.out.println(result);
    }
}