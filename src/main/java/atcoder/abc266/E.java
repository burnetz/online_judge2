package atcoder.abc266;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double dp[] = new double[n + 1];
        dp[1] = 3.5;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= 6; j++) {
                //出目よりもi - 1回以下再挑戦する方が期待値が高い場合は再チャレンジ
                if(dp[i - 1] > j) {
                    dp[i] += dp[i - 1] / 6;
                }
                //続ける期待値が高くない場合はそのまま出目を使う。
                else {
                    dp[i] += j / 6.0;
                }
            }
        }

        System.out.println(dp[n]);

    }

}
