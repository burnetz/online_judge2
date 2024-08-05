package atcoder.abc365;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long budget = sc.nextLong();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long left = 0;
        final long INF = 1_000_000_000_000_000L;
        long right = INF;
        while (left < right - 1) {
            long mid = (left + right) / 2;

            long tmpSum = 0;
            for(int i = 0; i < n; i++) {
                tmpSum += Math.min(a[i], mid);
            }

            if(tmpSum <= budget) {
                left = mid;
            }
            else {
                right = mid;
            }
        }

        if(left >= INF - 1) {
            System.out.println("infinite");
        }
        else {
            System.out.println(left);
        }

    }
}