
package atcoder.abc472;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(sum + a[i] > k) {
                System.out.println("No");
                a[i] = 0;
            }
            else {
                System.out.println("Yes");

                sum += a[i];
            }

            if(i >= m - 1) {
                sum -= a[i - m + 1];
            }
        }
    }
}