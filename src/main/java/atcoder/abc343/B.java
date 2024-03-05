package atcoder.abc343;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();

                if(a[i][j] == 1) {
                    System.out.print(j + 1 + " ");
                }
            }
            System.out.println();
        }

    }
}