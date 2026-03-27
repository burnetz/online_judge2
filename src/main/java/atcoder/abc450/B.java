package atcoder.abc450;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] costs = new int[n][n];
        for(int i = 0; i < n - 1 ; i++) {
            for(int j = i + 1; j < n; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 2; j < n; j++) {
                for(int k = i + 1; k < j; k++) {
                    if(costs[i][j] > costs[i][k] + costs[k][j]) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }
}