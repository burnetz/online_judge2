package atcoder.abc450;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        //kを足してもmodの値は変わらないため、最初から余りを取って良い。
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt() % k;
        }
        Arrays.sort(a);

        //どの要素をmin(A)にするのが最適かはn回調べないと分からないので
        //2周目のために配列を拡張しておく。
        int extended[] = new int[n * 2];
        for(int i = 0; i < n; i++) {
            extended[i] = a[i];
            extended[i + n] = a[i] + k;
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            result = Math.min(result, extended[i + n - 1] - extended[i]);
        }

        System.out.println(result);
    }
}