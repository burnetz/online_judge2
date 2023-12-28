package atcoder.abc307;

import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mod = 998244353;

        //dp[i][j] : 人1の数字をaに固定し、i番目までであり得るパターン数
        //           j = 0 : i番目でa以外 j = 1 : i番目でa
        long dp[][] = new long[n][2];
        dp[0][1] = 1;
        for(int i = 1; i < n; i++) {
            //直前に選んだ数およびaを選べない
            dp[i][0] = (dp[i - 1][0] * (m - 2) + dp[i - 1][1] * (m - 1)) % mod;
            //aしか選べないので直前はa以外
            dp[i][1] = dp[i - 1][0] % mod;
        }
        //aは実際にはmパターンあるので掛ける。
        System.out.println(dp[n - 1][0] * m % mod);
    }
}
