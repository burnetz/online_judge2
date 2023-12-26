package atcoder.abc334;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //トナカイの数について昇順で考えるのが最適
        long r[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();

        //累積和を計算しておけば二分探査できる。
        long sum[] = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + r[i - 1];
        }

        for(int i = 0; i < q; i++) {
            int index = Arrays.binarySearch(sum, sc.nextLong());

            if(index >= 0) {
                System.out.println(index);
            }
            else {
                System.out.println(-(index + 1) - 1);
            }
        }
    }
}
