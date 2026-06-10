package atcoder.abc458;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int matrix[][] = new int[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(i != 0) {
                    matrix[i][j]++;
                }
                if(j != w - 1) {
                    matrix[i][j]++;
                }
                if(i != h - 1) {
                    matrix[i][j]++;
                }
                if(j != 0) {
                    matrix[i][j]++;
                }

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}