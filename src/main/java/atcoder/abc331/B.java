package atcoder.abc331;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        int dp[] = new int[111];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {
            if(i >= 6) {
                dp[i] = Math.min(dp[i], dp[i - 6] + s);
            }
            if(i >= 8) {
                dp[i] = Math.min(dp[i], dp[i - 8] + m);
            }
            if(i >= 12) {
                dp[i] = Math.min(dp[i], dp[i - 12] + l);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = n; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
