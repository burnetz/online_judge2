package atcoder.abc365;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char command[] = sc.next().toCharArray();

        int dp[][] = new int[n][3];
        final int R = 0;
        final int S = 1;
        final int P = 2;

        final int MINF = -1000000;
        switch (command[0]) {
            case 'R' -> {
                dp[0][S] = MINF;
                dp[0][P] = 1;
            }
            case 'S' -> {
                dp[0][R] = 1;
                dp[0][P] = MINF;
            }
            case 'P' -> {
                dp[0][R] = MINF;
                dp[0][S] = 1;
            }
        }

        //一度でも負けた場合はその先で勝ってもカウントできないのでそこだけ注意する。
        //なお、ラウンドごとに見れば常に2通りの手が出せるので条件自体は必ず満たせる。
        for(int i = 1; i < n; i++) {
            switch (command[i]) {
                case 'R' -> {
                    dp[i][R] = Math.max(dp[i - 1][S], dp[i - 1][P]);
                    dp[i][S] = MINF;
                    dp[i][P] = Math.max(dp[i - 1][R] + 1, dp[i - 1][S] + 1);
                }
                case 'S' -> {
                    dp[i][R] = Math.max(dp[i - 1][S] + 1, dp[i - 1][P] + 1);
                    dp[i][S] = Math.max(dp[i - 1][R], dp[i - 1][P]);
                    dp[i][P] = MINF;
                }
                case 'P' -> {
                    dp[i][R] = MINF;
                    dp[i][S] = Math.max(dp[i - 1][R] + 1, dp[i - 1][P] + 1);
                    dp[i][P] = Math.max(dp[i - 1][R], dp[i - 1][S]);
                }
            }
        }

        System.out.println(Math.max(dp[n - 1][R], Math.max(dp[n - 1][S], dp[n - 1][P])));

    }
}