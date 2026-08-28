package atcoder.arc208;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] a = new long[n];

        long l = 1;
        long r = 1_000_000_000_000L;

        //先頭の要素としてあり得る最小値を二分探索で求める。
        //先頭が小さくなれば末尾の要素もより小さくできるが、先頭を小さくしすぎるとn個の要素だけではmod差の合計がKにならない。
        while(r - l > 1) {
            long mid = (l + r) / 2;

            long tmpK = k;

            a[0] = mid;
            //前の要素の2倍-1を上限として必要なだけ大きくし続けるのが最適。
            //modなのでa[i]をa[i - 1]*2より大きくするのは無駄になる。
            //増加させる必要が無くなったら同じ要素を繰り返せば良い。
            for(int i = 1; i < n; i++) {
                a[i] = Math.min(a[i - 1] * 2 - 1, a[i - 1] + tmpK);
                tmpK -= a[i] - a[i - 1];
            }

            if(tmpK == 0) {
                r = mid;
            }
            else {
                l = mid;
            }
        }

        long tmpK = k;
        a[0] = r;
        System.out.print(a[0] + " ");
        for(int i = 1; i < n; i++) {
            a[i] = Math.min(a[i - 1] * 2 - 1, a[i - 1] + tmpK);
            tmpK -= a[i] - a[i - 1];
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
