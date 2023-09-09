package atcoder.abc312;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        int n = str.length;

        //1文字ではそもそも不可能
        if(n == 1) {
            System.out.println(0);
            return;
        }

        int mod = 998244353;

        //dp[i][j] : i文字目まで見たときに'('がj個過剰になるパターン数。
        //)が途中で過剰になった場合は後で'('を追加しても正しい形式にならないので数えなくてよい。
        long[][] dp = new long[n][n];

        if(str[0] == '(' || str[0] == '?') {
            dp[0][1] = 1;
        }
        for(int i = 1; i < n;  i++) {
            if(str[i] == '(' || str[i] == '?') {
                for(int j = 1; j < n; j++) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
            if(str[i] == ')' || str[i] == '?') {
                for(int j = 0; j < n - 1; j++) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= mod;
                }
            }
        }

        //最後の文字まで見て'('の余剰がないパターンが答え
        System.out.println(dp[n - 1][0]);
    }
}
