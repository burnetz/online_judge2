package atcoder.abc408;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int result = solve(sc.next());
            System.out.println(result);
        }

    }

    static int INF = 1_000_000_000;

    static int solve(String s) {
        int n = s.length();

        //インデックス、変更後の数字（変更不要の場合も含む）、1で構成された区間数
        int dp[][][] = new int[n][2][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        if(s.charAt(0) == '0') {
            dp[0][0][0] = 0;
            dp[0][1][1] = 1;
        }
        else {
            dp[0][0][0] = 1;
            dp[0][1][1] = 0;
        }

        for(int i = 1; i < n; i++) {
            switch (s.charAt(i)) {
                case '0' -> {
                    dp[i][0][0] = dp[i - 1][0][0];
                    dp[i][0][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
                    dp[i][1][1] = Math.min(dp[i - 1][0][0] + 1, dp[i - 1][1][1] + 1);
                }
                case '1' -> {
                    dp[i][0][0] = Math.min(dp[i - 1][0][0] + 1, INF);
                    dp[i][0][1] = Math.min(dp[i - 1][0][1] + 1, dp[i - 1][1][1] + 1);
                    dp[i][1][1] = Math.min(dp[i - 1][0][0], dp[i - 1][1][1]);
                }
            }

        }

        //11..1の区間が全く無くても良いので注意
        return Math.min(dp[n - 1][0][0], Math.min(dp[n - 1][0][1], dp[n - 1][1][1]));
    }
}