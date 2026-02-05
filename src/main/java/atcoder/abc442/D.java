package atcoder.abc442;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long sum[] = new long[n + 1];

        for(int i = 0; i < n; i++) {
            sum[i + 1] = a[i] + sum[i];
        }

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int index = sc.nextInt() - 1;

                    sum[index + 1] += a[index + 1] - a[index];

                    int tmp = a[index];
                    a[index] = a[index + 1];
                    a[index + 1] = tmp;

                }
                case 2 -> {
                    int l = sc.nextInt() - 1;
                    int r = sc.nextInt();
                    System.out.println(sum[r] - sum[l]);
                }
            }
        }

    }
}