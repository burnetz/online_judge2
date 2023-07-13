package atcoder.abc306;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int poison[] = new int[n];
        int delicious[] = new int[n];

        for(int i = 0; i < n; i++){
            poison[i] = sc.nextInt();
            delicious[i] = sc.nextInt();
        }

        //dp[0] : fine  dp[1] : ill
        long dp[][] = new long[2][n];
        if(poison[0] == 0){
            dp[0][0] = Math.max(0, delicious[0]);
        }
        else {
            dp[1][0] = Math.max(0, delicious[0]);
        }

        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1];
            dp[1][i] = dp[1][i - 1];
            //解毒剤入なら直前の状態がどちらでもOK
            if(poison[i] == 0){
                dp[0][i] = Math.max(dp[0][i], Math.max(dp[0][i - 1] + delicious[i], dp[1][i - 1] + delicious[i]));
            }
            //毒入りなら直前の状態は元気でないと食べられない
            else {
                dp[1][i] = Math.max(dp[1][i], dp[0][i - 1] + delicious[i]);
            }
        }

        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
    }
}
