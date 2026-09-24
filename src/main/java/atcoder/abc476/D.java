
package atcoder.abc476;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();
        long b[] = Arrays.stream(new long[m]).map(e -> sc.nextLong()).sorted().toArray();

        long sumA[] = new long[n + 1];

        for(int i = 0; i < n; i++) {
            sumA[i + 1] = sumA[i] + a[i];
        }

        //デザートしか買わなかった場合。安い順に買うのが最適。
        int result = Arrays.binarySearch(sumA, x + y * k);
        if(result < 0) {
            result++;
            result *= -1;
            result--;
        }

        //ドリンクも複数買うのであれば安い順に買うべき。
        //ドリンク数に応じてデザートの購入可能数を都度計算する。
        for(int i = 0; i < m; i++) {
            long requireBill = (b[i] + k - 1) / k;

            if(requireBill > y) {
                break;
            }

            y -= requireBill;
            x += (k - b[i] % k) % k;

            int tmpIndex = Arrays.binarySearch(sumA, x + y * k);
            if(tmpIndex < 0) {
                tmpIndex++;
                tmpIndex *= -1;
                tmpIndex--;
            }

            result = Math.max(result, i + 1 + tmpIndex);
        }

        System.out.println(result);
    }
}