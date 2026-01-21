package atcoder.abc438;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] b = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] c = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long[] sumA = new long[n + 1];
        long[] sumB = new long[n + 1];
        long[] sumC = new long[n + 1];

        for(int i = 1; i <= n; i++) {
            sumA[i] = sumA[i - 1] + a[i - 1];
            sumB[i] = sumB[i - 1] + b[i - 1];
            sumC[i] = sumC[i - 1] + c[i - 1];
        }

        long result = 0;
        //そこまで全てBを選ばずにAに割り当てたことによる機会損失を考慮した最大値を考える。
        //その値のピークより後はBもしくはCにするのが最適。
        int maxAMinusBIndex = 1;
        //Bの末尾のインデックスについてループさせる。Cの長さは自ずと決まる。
        for(int i = 2; i < n ; i++) {
            long maxDiff = sumA[maxAMinusBIndex] - sumB[maxAMinusBIndex];
            long tmpDiff = sumA[i] - sumB[i];

            if(tmpDiff > maxDiff) {
                maxAMinusBIndex = i;
            }

            long tmpResult = maxDiff + sumB[i] + (sumC[n] - sumC[i]);

            result = Math.max(result, tmpResult);
        }

        System.out.println(result);
    }
}