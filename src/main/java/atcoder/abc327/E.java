package atcoder.abc327;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] performances = Arrays.stream(new double[n]).map(e -> sc.nextDouble()).toArray();

        //dp[i][j] : i番目まででj回選んだ場合の第1項分子の最大値。
        //それ以外（分母、第2項）は記憶する必要が無い。
        double[][] dp = new double[n + 1][n + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                //j回目の成績を選ぶか選ばないか
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] * 0.9 + performances[i - 1]);
            }
        }

        double result = -1201;
        //何回分選ぶのが最適なのかはわからないので全て試す。
        for(int i = 1; i <= n; i++) {
            double divisor = 10 - 10*Math.pow(0.9, i);
            double tmpResult = dp[n][i] / divisor - 1200/Math.sqrt(i);
            result = Math.max(result, tmpResult);
        }

        System.out.println(result);
    }
}
