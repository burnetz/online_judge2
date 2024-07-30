package atcoder.abc364;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();
        long y = sc.nextLong();

        long a[] = new long[n];
        long b[] = new long[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for(int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long sumA = 0;
        long sumB = 0;
        for(int i = 0; i < n; i++) {
            sumA += a[n - i - 1];
            sumB += b[n - i - 1];

            if(sumA > x) {
                System.out.println(i + 1);
                return;
            }
            if(sumB > y) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(n);
    }
}