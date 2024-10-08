package atcoder.abc370;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int matrix[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                int a = sc.nextInt() - 1;

                matrix[i][j] = a;
                matrix[j][i] = a;
            }
        }

        int current = 0;
        for(int i = 0; i < n; i++) {

            current = matrix[current][i];
        }

        System.out.println(current + 1);
    }
}