package atcoder.arc226;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mod = 998244353;
        int inverse = 499122177;

        Meeting[] meetings = new Meeting[n];
        boolean[] enter = new boolean[2 * n + 1];
        boolean[] exit = new boolean[2 * n + 1];
        for(int i = 0; i < meetings.length; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
            enter[meetings[i].start()] = true;
            exit[meetings[i].end()] = true;
        }
        long dp[][][] = new long[2 * n + 1][2][2];
        dp[0][0][0] = 1;

        for(int i = 1; i <= 2 * n; i++) {
            if(enter[i]) {
                dp[i][0][0] = 0;
                dp[i][0][1] = dp[i - 1][0][0];
                dp[i][1][0] = dp[i - 1][0][0];
                dp[i][1][1] = dp[i - 1][0][1] + dp[i - 1][1][0];
            }
            else if (exit[i]) {
                dp[i][0][0] = dp[i - 1][0][1] + dp[i - 1][1][0];
                dp[i][0][1] = dp[i - 1][1][1] * inverse;
                dp[i][1][0] = dp[i - 1][1][1] * inverse;
                dp[i][1][1] = 0;
            }
            else {
                dp[i][0][0] = dp[i - 1][0][0];
                dp[i][0][1] = dp[i - 1][0][1];
                dp[i][1][0] = dp[i - 1][1][0];
                dp[i][1][1] = dp[i - 1][1][1];
            }

            dp[i][0][0] %= mod;
            dp[i][0][1] %= mod;
            dp[i][1][0] %= mod;
            dp[i][1][1] %= mod;
        }

        System.out.println(dp[2 * n][0][0] + dp[2 * n][0][1] + dp[2 * n][1][0] + dp[2 * n][1][1]);
    }

}

record Meeting(int start, int end) {}