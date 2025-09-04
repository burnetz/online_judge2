package atcoder.abc410;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        int m = sc.nextInt();

        //回数とHPについてテーブルを作ってMPを保存する。
        //3次元テーブルにする必要はない。
        int dp[][] = new int[n + 1][h + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][h] = m;

        int result = 0;
        for(int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = 0; j <= h; j++) {
                boolean win = false;

                if(j + a <= h) {
                    dp[i][j] = dp[i - 1][j + a];
                    if(dp[i][j] >= 0) {
                        win = true;
                    }
                }
                if(dp[i - 1][j] >= b) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - b);
                    win = true;
                }

                //どこまで勝てるかを後から調べるのは割と面倒なのでDPテーブル埋めをしながら求める。
                if(win) {
                    result = i;
                }
            }
        }

        System.out.println(result);
    }
}