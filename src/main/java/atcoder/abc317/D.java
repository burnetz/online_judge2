package atcoder.abc317;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int takahashi[] = new int[n + 1];
        int aoki[] = new int[n + 1];
        int seat[] = new int[n + 1];
        int seatTotal = 0;

        for(int i = 1; i <= n; i++) {
            takahashi[i] = sc.nextInt();
            aoki[i] = sc.nextInt();
            seat[i] = sc.nextInt();
            seatTotal += seat[i];
        }

        //dp[i][j] : i番目の選挙区まで見たときにj議席獲得のために最低限鞍替えさせる必要のある人数
        long dp[][] = new long[n + 1][1_000_002];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1_000_000_000_000_000L);
        }
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            int require = Math.max ((takahashi[i] + aoki[i])/2 + 1 - takahashi[i], 0);
            for(int j = 0 ; j <= 1_000_000; j++) {
                //何もしない場合
                dp[i][j] = dp[i - 1][j];
                //鞍替えをさせる場合
                if(j >= seat[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j - seat[i]] + require, dp[i][j]);
                }
            }
        }

        //上記のループでは値が飛び飛びになり単調な変化ではないので
        //過半数議席についてループを回して最小値を探す。
        long result = Long.MAX_VALUE;
        for(int i = seatTotal / 2 + 1; i <= 1_000_000; i++) {
            result = Math.min(result, dp[n][i]);
        }
        System.out.println(result);
    }
}
