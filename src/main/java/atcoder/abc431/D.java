package atcoder.abc431;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //体と頭の重さの差について嬉しさをメモ。ただし1..nのついて記録するとREになるのでメモリを節約。
        //また、頭が重い場合インデックスが負になってしまうのでオフセットを使う。
        long[][] dp = new long[2][500 * 500 * 2 + 1];
        int offset = 500 * 500;

        for(int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        dp[0][offset] = 0;

        for(int i = 1; i <= n; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int b = sc.nextInt();

            //頭として使う
            for(int j = 0; j < dp[0].length - w; j++) {
                dp[1][j] = Math.max(dp[1][j], dp[0][j + w] + h);
            }

            //体として使う
            for(int j = w; j < dp[0].length; j++) {
                dp[1][j] = Math.max(dp[1][j], dp[0][j - w] + b);
            }

            //移し替え
            for(int j = 0; j < dp[0].length; j++) {
                dp[0][j] = dp[1][j];
            }
        }

        long result = 0;

        //答えに使えるのは体の重さが頭の重さ以上となる場合のみ
        for(int i = offset; i < dp[0].length; i++) {
            result = Math.max(result, dp[0][i]);
        }

        System.out.println(result);
    }
}