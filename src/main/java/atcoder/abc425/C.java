package atcoder.abc425;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long sum[] = new long[n + 1];

        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }

        int base = 0;

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    base = (base + sc.nextInt()) % n;
                }
                case 2 -> {
                    int l = sc.nextInt();
                    int r = sc.nextInt();

                    if(l + base > n) {
                        int l1 = (l + base) % n - 1;
                        int r1 = (r + base) % n;

                        System.out.println(sum[r1] - sum[l1]);
                    }
                    else {
                        if(r + base > n) {
                            long tmpSum = sum[n] - (sum[l + base - 1] - sum[(r + base) % n]);

                            System.out.println(tmpSum);
                        }
                        else {
                            long tmpSum = sum[r + base] - sum[l + base - 1];

                            System.out.println(tmpSum);
                        }
                    }
                }
            }
        }
    }
}