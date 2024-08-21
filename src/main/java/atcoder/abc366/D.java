package atcoder.abc366;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][][] data = new int[n + 1][n + 1][n + 1];
        //dp[i][j][k] : 原点から(i, j, k)までに含まれる全ての値の和
        long[][][] dp = new long[n + 1][n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    data[i][j][k] = sc.nextInt();
                    dp[i][j][k] = data[i][j][k] + dp[i - 1][j][k] + dp[i][j - 1][k] + dp[i][j][k - 1]
                                    - dp[i - 1][j - 1][k] - dp[i][j - 1][k - 1] - dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k - 1];
                }
            }
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int lx = sc.nextInt();
            int rx = sc.nextInt();
            int ly = sc.nextInt();
            int ry = sc.nextInt();
            int lz = sc.nextInt();
            int rz = sc.nextInt();

            long sec1 = dp[rx][ry][lz - 1];
            long sec2 = dp[rx][ly - 1][rz] - dp[rx][ly - 1][lz - 1];
            long sec3 = dp[lx - 1][ry][rz] - dp[lx- 1][ly - 1][rz] - dp[lx - 1][ry][lz - 1] + dp[lx - 1][ly - 1][lz - 1];

            long result = dp[rx][ry][rz] - sec1 - sec2 - sec3;

            System.out.println(result);
        }
    }
}