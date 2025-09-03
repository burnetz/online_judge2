package atcoder.abc403;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int limit = 1_000_000;

        int count[] = new int[limit + 1];

        //数字の出現頻度をメモ
        Arrays.stream(a).forEach(e -> {
            count[e]++;
        });

        //D=0のときはこの後の処理ができないためここで片付ける。
        if(d == 0) {
            int result = 0;

            for(int i = 0; i <= limit; i++) {
                if(count[i] > 1) {
                    result += count[i] - 1;
                }
            }

            System.out.println(result);
            return;
        }

        //dp[i][j] : i番目の数字を(j=0 : 消す j=1 : 残す)パターン数。
        //ただしDで割った余りごとに考える。最終的にはLIMIT-DからLIMITまでの結果を足す。
        int dp[][] = new int[limit + 1][2];
        int INF = 9_999_999;

        for(int i = 0; i <= limit ; i++) {
            if(count[i] == 0) {
                dp[i][1] = INF;
            }
            //削除する場合は同じ数字を全て削除する。
            else {
                dp[i][0] = count[i];
            }

            if(i >= d) {
                //i番目を削除するならi-D番目は自由
                dp[i][0] += Math.min(dp[i - d][0], dp[i - d][1]);
                //i番目を残すならi-D番目は必ず削除
                dp[i][1] = Math.min(INF, dp[i][1] + dp[i - d][0]);
            }

        }

        int result = 0;

        for(int i = Math.max(0, limit - d + 1); i <= limit ; i++) {
            result += Math.min(dp[i][0], dp[i][1]);
        }

        System.out.println(result);
    }
}