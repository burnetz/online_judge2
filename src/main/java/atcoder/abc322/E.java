package atcoder.abc322;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();

        int costs[] = new int[n];
        int matrix[][] = new int[n][k];
        for(int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
            for(int j = 0; j < k; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int stateNum = (int)Math.pow(p + 1, k);

        final long INF = 1_000_000_000_000_000L;

        //pを超えた分のパラメータをpに丸めれば状態数が(p + 1)^kで済むのでDP可能
        long dp[][] = new long[n + 1][stateNum];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < stateNum; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for(int j = 0; j < stateNum; j++) {
                int[] stateArray = decode(k, p + 1, j);

                int nextStateArray[] = new int[k];
                for(int q = 0; q < k; q++) {
                    //pを超えた分はpに丸める。
                    nextStateArray[q] = Math.min(stateArray[q] + matrix[i - 1][q], p);
                }

                int nextStateValue = encode(k, p + 1, nextStateArray);

                dp[i][nextStateValue] = Math.min(dp[i][nextStateValue], dp[i - 1][j] + costs[i - 1]);
            }
        }

        if(dp[n][stateNum - 1] == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[n][stateNum - 1]);
        }
    }

    //状態をintに変換する
    static int encode(int k, int p, int[] a) {
        int result = 0;
        int geta = 1;
        for(int i = 0; i < k; i++) {
            result += a[k - i - 1] * geta;
            geta *= p;
        }

        return result;
    }

    //intを状態に変換する
    static int[] decode(int k, int p, int value) {
        int[] result = new int[k];
        int index = k - 1;
        while(value > 0) {
            result[index--] = value % p;
            value /= p;
        }

        return result;
    }
}