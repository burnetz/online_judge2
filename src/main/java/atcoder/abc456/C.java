package atcoder.abc456;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int mod = 998244353;

        long dp[] = new long[str.length() + 1];
        dp[1] = 1;
        for(int i = 2; i <= str.length(); i++) {
            if(str.charAt(i - 2) == str.charAt(i - 1)) {
                dp[i] = 1;
            }
            else {
                dp[i] = dp[i - 1] + 1;
                dp[i] %= mod;
            }
        }

        long result = Arrays.stream(dp).sum() % mod;

        System.out.println(result);
    }
}