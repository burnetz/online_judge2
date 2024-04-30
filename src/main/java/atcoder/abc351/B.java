package atcoder.abc351;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] matrix = new char[2*n][n];

        for(int i = 0; i < 2*n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != matrix[i + n][j]) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}