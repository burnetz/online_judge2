
package atcoder.abc474;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        long b[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long w[] = new long[n];
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < n; i++) {
            if(a[i] <= b[i]) {
                w[i] = 1;
            }
            else {
                w[i] = 1_000_000_000_000_000_000L;
            }
            sum = sum.add(new BigInteger(Long.toString(w[i])).multiply(new BigInteger(Long.toString((long)a[i] - b[i]))));
        }
        if(sum.compareTo(new BigInteger("0")) > 0) {
            System.out.println("Yes");

            for(int i = 0; i < n; i++) {
                System.out.print(w[i] + " ");
            }
        }
        else {
            System.out.println("No");
        }
    }
}