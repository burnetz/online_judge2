package atcoder.arc194;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //スタックとしての動きを意識しなくても
        //今見ている要素を足すか足さずにインデックスを2つ進めるかの2択だと考えても良い。
        //dp[i][j] : j = 0 i番目の要素を足さない j = 1 i番目の要素を足す
        long dp[][] = new long[n][2];

        //初手はスキップを選べないので無効な値を入れておく
        dp[0][0] = -1_000_000_000_000L;
        dp[0][1] = a[0];
        if(n >= 2) {
            dp[1][0] = 0;
            dp[1][1] = a[1] + a[0];
        }

        for(int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + a[i];
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}
