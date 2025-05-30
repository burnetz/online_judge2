package atcoder.abc401;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int mod = 1_000_000_000;

        if(n < k) {
            System.out.println(1);
            return;
        }

        long sum[] = new long[n + 1];
        long a[] = new long[n + 1];
        for(int i = 0; i < k; i++) {
            a[i] = 1;
        }

        for(int i = 1; i < k; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
            if(sum[i] >= mod) {
                sum[i] %= mod;
            }
        }

        for(int i = k ; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
            if(sum[i] >= mod) {
                sum[i] %= mod;
            }
            a[i] = sum[i] - sum[i - k];

            if(a[i] < 0) {
                a[i] += mod;
            }
        }

//        Arrays.stream(a).forEach(System.out::println);
//        System.out.println();
//        Arrays.stream(sum).forEach(System.out::println);

        System.out.println(a[n]);
    }
}