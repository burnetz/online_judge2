package atcoder.abc346;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        long cost[] = Arrays.stream(new long[n]).map(e -> sc.nextInt()).toArray();

        //dp[i][0] : 0から始めてi文字目まで交互にするためのコスト
        //dp[i][1] : 1から始めてi文字目まで交互にするためのコスト
        long dp[][] = new long[n + 1][2];

        for(int i = 0; i < n; i++) {
            //それぞれの数字を0と1のどちらにすべきかは最初の数字およびインデックスの偶奇で決まる。
            switch ((str.charAt(i) - '0' + i) % 2) {
                case 0 -> {
                    dp[i + 1][0] = dp[i][0];
                    dp[i + 1][1] = dp[i][1] + cost[i];
                }
                case 1 -> {
                    dp[i + 1][0] = dp[i][0] + cost[i];
                    dp[i + 1][1] = dp[i][1];
                }
            }
        }

        long result = Long.MAX_VALUE;

        //途中でタイプを変えることで1箇所だけ数字が連続する。
        for(int i = 1; i < n ; i++) {
            long tmp1 = dp[i][0] + (dp[n][1] -dp[i][1]);
            long tmp2 = dp[i][1] + (dp[n][0] -dp[i][0]);

            result = Math.min(result, Math.min(tmp1, tmp2));
        }

        System.out.println(result);

    }
}