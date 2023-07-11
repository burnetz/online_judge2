package atcoder.abc309;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char matrix[][] = new char[n][n];

        for(int i = 0; i < n; i++){
            matrix[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j != 0){
                    System.out.print(matrix[i][j - 1]);
                }
                else if(j == n - 1 && i != 0){
                    System.out.print(matrix[i - 1][j]);
                }
                else if(i == n - 1 && j != n - 1) {
                    System.out.print(matrix[i][j + 1]);
                }
                else if(j == 0 && i != n - 1){
                    System.out.print(matrix[i + 1][j]);
                }
                else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
