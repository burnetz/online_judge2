
package atcoder.abc464;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        String str = sc.next();

        int[] x = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] y = Arrays.stream(new int[n - 1]).map(e -> sc.nextInt()).toArray();

        //dp[i][j] : i日目の天気がj = 0 : 晴れ j = 1 : 雨の場合の幸福度の最大値
        long dp[][] = new long[n][2];
        if(str.charAt(0) == 'S') {
            dp[0][1] = -x[0];
        }
        else {
            dp[0][0] = -x[0];
        }

        for(int i = 1; i < n; i++) {
            if(str.charAt(i) == 'S') {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + y[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) - x[i];
            }
            else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + y[i - 1]) - x[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}