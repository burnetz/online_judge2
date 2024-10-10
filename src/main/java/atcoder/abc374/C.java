package atcoder.abc374;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] k = new long[n];

        for(int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }

        long result = Long.MAX_VALUE;
        for(int i = 0; i < Math.pow(2, n) ; i++) {
            int mask = 1;

            long sumA = 0;
            long sumB = 0;
            for(int j = 0; j < n; j++) {
                if((mask & i) == 0) {
                    sumA += k[j];
                }
                else {
                    sumB += k[j];
                }
                mask *= 2;
            }

//            System.out.println("A: " + sumA + " B: "+ sumB);
            result = Math.min(result, Math.max(sumA, sumB));
        }

        System.out.println(result);
    }
}