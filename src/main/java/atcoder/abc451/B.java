package atcoder.abc451;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int dept[][] = new int[m][2];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                dept[sc.nextInt() - 1][j]++;
            }
        }

        for(int i = 0; i < m; i++) {
            System.out.println(dept[i][1] - dept[i][0]);
        }
    }
}