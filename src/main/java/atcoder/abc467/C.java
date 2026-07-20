
package atcoder.abc467;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] b = Arrays.stream(new int[n - 1]).map(e -> sc.nextInt()).toArray();

        //dp[i][j] : 条件を見たしつつa[i]をjにした場合の最小コスト
        int dp[][] = new int[n][2];

        if(a[0] == 0) {
            dp[0][1] = 1;
        }
        else {
            dp[0][0] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(b[i - 1] == 0) {
                if(a[i] == 0) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = dp[i - 1][1];
                }
            }
            else {
                if(a[i] == 0) {
                    dp[i][0] = dp[i - 1][1];
                    dp[i][1] = dp[i - 1][0] + 1;
                }
                else {
                    dp[i][0] = dp[i - 1][1] + 1;
                    dp[i][1] = dp[i - 1][0];
                }
            }
        }

        System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
    }
}