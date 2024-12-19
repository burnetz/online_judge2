package atcoder.abc384;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long s = sc.nextLong();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //必要な部分和をいつでも計算できるようにする。
        //2周分あれば十分
        long sum[] = new long[2*n + 1];
        for(int i = 1; i <= 2*n; i++) {
            sum[i] = a[(i - 1)%n] + sum[i - 1];
        }

        //元々のa[1]~a[n]の和
        long total = sum[n];

        //総和のうちa[i]~a[n]をまるごと使う部分は無視できる。
        s %= total;

        if(s == 0) {
            System.out.println("Yes");
            return;
        }

        //残りの部分和を作る方法が存在するか調べる。
        for(int i = 1; i <= 2*n; i++) {
            if(sum[i] < s) {
                continue;
            }
            long extra = sum[i] - s;
            int index = Arrays.binarySearch(sum, extra);
            if(index >= 0 ) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}