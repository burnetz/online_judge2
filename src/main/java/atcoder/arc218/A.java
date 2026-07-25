package atcoder.arc218;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).sorted().toArray();
        }

        int limit = 500 * 500;
        //dp[0][j] : 直前まででjが使われたことがないパターン数
        //nセット分のデータを保持するとREになるので最低限必要なデータを適宜移し替える。
        long dp[][] = new long[2][limit + 1];
        Arrays.fill(dp[0], 1);

        long sum[] = new long[n + 1];
        sum[1] = m;

        for(int i = 1; i <= n; i++) {
            int count[] = new int[limit + 1];
            for(int j = 0; j < m; j++) {
                count[matrix[i - 1][j]]++;
            }
            for(int j = 1; j <= limit; j++) {
                dp[1][j] += dp[0][j] * (m - count[j]);
                dp[1][j] %= mod;
            }

            if(i > 1) {
                //種類が増えなかったとしても直前までの結果をm回足す必要がある。
                sum[i] = m * sum[i - 1];
                //こちらは種類が増えるパターンの差分を計算している。
                for (int j = 0; j < m; j++) {
                    sum[i] += dp[0][matrix[i - 1][j]];
                }
                sum[i] %= mod;
            }

            for(int j = 1; j <= limit; j++) {
                dp[0][j] = dp[1][j];
                dp[1][j] = 0;
            }
        }

        System.out.println(sum[n]);


    }

    static int mod = 998244353;
    static int matrix[][];

}
