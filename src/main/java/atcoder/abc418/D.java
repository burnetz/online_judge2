package atcoder.abc418;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();

        //dp[i][j] : i文字目で終わりjに圧縮できる文字列の作り方
        long dp[][] = new long[n][2];

        if(s.charAt(0) == '0') {
            dp[0][0] = 1;
        }
        else {
            dp[0][1] = 1;
        }

        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == '0') {
                //1文字だけでも作れるので忘れずにカウント
                dp[i][0] = 1;

                //10は0になり、00は1になる。
                dp[i][0] += dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }
            else {
                dp[i][1] = 1;

                dp[i][0] = dp[i - 1][0];
                dp[i][1] += dp[i - 1][1];
            }
        }

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += dp[i][1];
        }

        System.out.println(sum);
    }
}