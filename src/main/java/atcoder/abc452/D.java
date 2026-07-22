package atcoder.abc452;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        //dp[i][j] : Sのi文字目まで見たときに、Tのj文字目までの部分列が収まる最大のインデックス
        //Tの長さがとても短いのでこのようにデータを管理できる。
        int dp[][] = new int[s.length()][t.length() + 1];
        for(int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1_000_000_000);
        }

        dp[0][0] = 1;
        if(s.charAt(0) == t.charAt(0)) {
            dp[0][1] = 0;
        }

        for(int i = 1; i < s.length(); i++) {
            dp[i][0] = i + 1;
            for(int j = 1; j <= t.length() ; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
            for(int j = 0; j < t.length(); j++) {
                if(t.charAt(j) == s.charAt(i)) {
                    dp[i][j + 1] = dp[i - 1][j];
                }
            }
        }

        long result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(dp[i][t.length()] >= 0) {
                result += i - dp[i][t.length()];
            }
            else {
                result += i + 1;
            }
        }

        System.out.println(result);
    }
}