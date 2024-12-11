package atcoder.abc369;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //討伐数が偶数か奇数かに分けて管理する。
        long dp[][] = new long[n][2];
        dp[0][1] = a[0];

        for(int i = 1; i < n; i++) {
            //いずれの場合もi体目を討伐するかしないかのうちより大きい方を選ぶ。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + a[i] * 2);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + a[i]);
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}