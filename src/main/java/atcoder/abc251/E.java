package atcoder.abc251;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //dp[i][j] : j = 0 : (n, 1)を使わない j = 1 : (n, 1)を使う
        long dp[][] = new long[n + 1][2];
        //(n, 1)を使わずに1番目を完成させることは不可能
        dp[1][0] = Integer.MAX_VALUE;
        //(n, 1)を使うことが確定しているので何も完成させないのは不可能
        dp[0][1] = Integer.MAX_VALUE;
        //(n, 1)を使う場合はそのコストが1番目完成のためのコストになる。
        dp[1][1] = a[n - 1];
        for(int i = 2; i <= n; i++) {
            //いずれのパターンについても1匹重なるパターンと全く重ねないパターンを考える。
            dp[i][0] = Math.min(dp[i - 1][0] + a[i - 2], dp[i - 2][0] + a[i - 2]);
            dp[i][1] = Math.min(dp[i - 1][1] + a[i - 2], dp[i - 2][1] + a[i - 2]);
        }

        //ごく稀にだが、(n, 1)を使った上で更に(n - 1, n)を使ったほうが良いパターンが存在する。
        long result = Math.min(Math.min(dp[n][0], dp[n - 1][1]), dp[n][1]);
        System.out.println(result);
    }

}
