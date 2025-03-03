package atcoder.abc395;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] matrix = new char[n][n];

        for(int i = 0; i <= n / 2; i++) {
            char c = i % 2 == 0 ? '#' : '.';
            for(int j = i; j < n - i; j++) {
                for(int k = i; k < n - i; k++) {
                    matrix[j][k] = c;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(matrix[i]);
        }
    }
}