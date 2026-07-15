package atcoder.arc224;

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
        long n = sc.nextLong();

        //nが大きいのでsqrt()を使うと多分バグる。そのため二分探索で平方根を求める。
        long l = -1;
        long r = 1_000_000_001;

        while(r - l > 1) {
            long mid = (r + l) / 2;

            if(mid * mid <= n) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        long sum = 0;
        //結論としては正方形に近づけるのが最適。
        //ペアを考えるときに「右と下にしか繋げられない」と考えると
        //正方形ならほとんどのタイルから矢印を2本引けることを納得しやすい。
        if(l >= 2) {
            //最大の正方形に相当する矢印の本数
            sum += 2 * (l - 1) * (l - 1) + (l - 1) + (l - 1);
        }
        //残ったタイルは右の一列と下の1行に並べる。
        long remain = n - l * l;
        long right = Math.min(l, remain);
        if(right >= 1) {
            sum += right * 2 - 1;
        }
        long bottom = remain - right;
        if(bottom >= 1) {
            sum += bottom * 2 - 1;
        }

        System.out.println(sum);

    }
}