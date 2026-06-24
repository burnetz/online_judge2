package atcoder.abc457;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long l = 0;
        //解としてあり得る値の最大値はかなり大きくなる。
        long r = 2_000_000_000_000_000_001L;

        //二分探索で答えを絞り込む。計算量はO(N log(N))
        while(r - l > 1) {
            long mid = (r + l) / 2;

            long count = 0;
            for(int i = 0; i < n; i++) {
                long remain = Math.max(0, mid - a[i]);
                count += (remain + i) / (i + 1);
                if(count > k) {
                    break;
                }
            }

            if(count > k) {
                r = mid;
            }
            else {
                l = mid;
            }
        }

        System.out.println(l);
    }
}