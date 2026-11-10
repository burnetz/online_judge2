
package atcoder.abc483;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        int[] b = new int[n];
        for(int i = 0; i < q; i++) {
            int k = sc.nextInt();
            if (k >= 0) System.arraycopy(a, 0, b, 0, k);

            for(int j = 0; j < k ; j++) {
                a[j] = b[k - j - 1] * (-1);
            }
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}