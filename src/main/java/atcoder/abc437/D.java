package atcoder.abc437;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        double[] a = Arrays.stream(new double[n]).map(e -> sc.nextInt()).toArray();
        double[] b = Arrays.stream(new double[m]).map(e -> sc.nextInt()).sorted().toArray();

        int mod = 998244353;

        long[] sumB = new long[m + 1];

        for(int i = 1; i <= m; i++) {
            sumB[i] = sumB[i - 1] + (int)b[i - 1];
        }

        long result = 0;
        for(int i = 0; i < n; i++) {
            //lower_boundと同じ動きになるようわざとdoubleにしてある（必ずヒットしなくなる）
            int index = Arrays.binarySearch(b, a[i] - 0.5);
            index = - (index + 1);

            //a[i]と比べて小さいものと大きいもので加算の仕方を変える
            long tmpSum = (long)a[i] * index - sumB[index];
            tmpSum += sumB[m] - sumB[index] - (long)a[i] * (m - index);

            result += tmpSum;
            result %= mod;
        }

        System.out.println(result);
    }
}