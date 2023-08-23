package atcoder.abc303;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();
        long z = sc.nextLong();

        char[] str = sc.next().toCharArray();
        //dp[0][i] : i文字終了後にcaps off dp[1][i] : i文字終了後にcaps on の場合の最短時間
        long[][] dp = new long[2][str.length];

        //shift + A よりもcaps A capsの方が早い場合もある。
        //いろいろなパターンを想定する。
        if(str[0] == 'a') {
            dp[0][0] = Math.min(x, z + y + z);
            dp[1][0] = Math.min(x + z, z + y);
        }
        else {
            dp[0][0] = Math.min(y, z + x + z);
            dp[1][0] = Math.min(z + x, y + z);
        }

        for(int i = 1; i < str.length; i++){
            if(str[i] == 'a'){
                dp[0][i] = Math.min(dp[0][i - 1] + Math.min(x, z + y + z), dp[1][i - 1] + Math.min(z + x, y + z));
                dp[1][i] = Math.min(dp[0][i - 1] + Math.min(x + z, z + y), dp[1][i - 1] + Math.min(y, z + x + z));
            }
            else {
                dp[0][i] = Math.min(dp[0][i - 1] + Math.min(y, z + x + z), dp[1][i - 1] + Math.min(x + z, z + y));
                dp[1][i] = Math.min(dp[0][i - 1] + Math.min(z + x, y + z), dp[1][i - 1] + Math.min(x, z + y + z));
            }
        }

        System.out.println(Math.min(dp[0][str.length - 1], dp[1][str.length - 1]));
    }
}
