package atcoder.abc456;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int mod = 998244353;

        //dp[i][j] : i文字目までで末尾の文字がjである部分列のパターン数
        long dp[][] = new long[str.length() + 1][26];

        for(int i = 1; i <= str.length(); i++) {
            int c = str.charAt(i - 1) - 'a';

            //i文字目から始まるパターンが必ず1つ存在する。
            dp[i][c] = 1;
            for(int j = 0; j < 26; j++) {
                //i文字目を使わないパターン
                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= mod;

                //i文字目を使うパターンでは末尾の文字に注意する
                if(j == c) {
                    continue;
                }

                dp[i][c] += dp[i - 1][j];
                dp[i][c] %= mod;
            }
        }

        long sum = Arrays.stream(dp[str.length()]).sum() % mod;

        System.out.println(sum);
    }
}