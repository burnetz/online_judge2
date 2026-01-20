package atcoder.abc440;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0 ; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] c = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //あるマスの色を変えたらそこからwの間隔で色変更が発生するので合計コストを求める。
        long[] skippedSum = new long[w * 2];
        for(int i = 0; i < w * 2; i++) {
            for(int j = i; j < n; j += w * 2) {
                skippedSum[i] += c[j];
            }
        }

        //上記の和の累積和
        long[] sum = new long[w * 2 + 1];

        for(int i = 1; i <= w * 2; i++) {
            sum[i] = sum[i - 1] + skippedSum[i - 1];
        }

        long result = Long.MAX_VALUE;
        //既に求めた合計を利用することで1周期分のループで計算可能
        for(int i = 0; i < w * 2; i++) {
            long tmpResult = sum[Math.min(i + w, w * 2)] - sum[i] + sum[Math.max(i - w, 0)];

            result = Math.min(tmpResult, result);
        }

        System.out.println(result);
    }
}