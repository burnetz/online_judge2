package atcoder.arc166;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long num[] = new long[n];
        for(int i = 0; i < n; i++) {
            num[i] = sc.nextLong();
        }

        //dp[i][j]: i番目の要素まで見たときに状態jとなるための最短コスト。
        //状態は3ビットで各ビットがa, b, cそれぞれの倍数を含むということを意味する。
        long dp[][] = new long[n + 1][8];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1_000_000_000_000_000_000L);
        }
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 7; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            //i番目の数字を使ってa,b,cの特定の倍数のみを満たすようにする
            //or全部満たすようにするなど全部で8パターンの選択肢がある。
            for(int j = 0; j <= 7; j++) {
                long lcm = 1;
                if ((j & 1) != 0) {
                    lcm = lcm(lcm, a);
                }
                if ((j & 2) != 0) {
                    lcm = lcm(lcm, b);
                }
                if ((j & 4) != 0) {
                    lcm = lcm(lcm, c);
                }
                //条件を満たすためのコストを求める。
                long diff = (lcm - num[i - 1] % lcm)%lcm;
                //OR演算を使えばループでまとめられる。
                //例えば状態011（a,bは満たしている）と状態110（b,cは満たしている）でORを取れば
                //111（3つとも満たしている）になる。
                for(int k = 0; k <= 7; k++) {
                    dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][k] + diff);
                }
            }
        }

        System.out.println(dp[n][7]);
    }

    static long gcd(long a, long b){
        long tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }

    static long lcm(long a, long b, long gcd){
        return (long)a*(b/gcd);
    }

    static long lcm(long a, long b){
        long g = gcd(a, b);

        return lcm(a,b,g);
    }
}