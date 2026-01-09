package atcoder.abc436;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int matrix[][] = new int[n][n];

        int r = 0;
        int c = (n - 1)/2;
        matrix[r][c] = 1;

        for(int i = 2; i <= n * n ; i++) {
            int nextR = (r + n - 1) % n;
            int nextC = (c + 1) % n;

            if(matrix[nextR][nextC] == 0) {
                matrix[nextR][nextC] = i;
            }
            else {
                nextR = (r + 1) % n;
                nextC = c;
                matrix[nextR][nextC] = i;
            }

            r = nextR;
            c = nextC;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}