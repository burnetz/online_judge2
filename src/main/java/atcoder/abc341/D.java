package atcoder.abc341;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        //後続の処理での扱いが面倒なのでK = 1のときはここで処理
        if(k == 1) {
            System.out.println(Math.min(n, m));
            return;
        }

        long lcm = lcm(n, m);

        //公倍数から次の公倍数までの倍数の個数。常に同じ間隔になる。
        int interval = (int)(lcm / m + lcm / n - 1);

        long times = k / (interval - 1);

        //1からKまでループを回すわけには行かないのでサイクル数と余りを考える。
        long base = times * lcm;
        int remain = (int)(k % (interval - 1));

        //余りが0のときは後続のループでは求められないのでここで計算する。
        if(remain == 0) {
            System.out.println(Math.max(base - m, base - n));
            return;
        }

        long n2 = base;
        long m2 = base;
        //Nの倍数とMの倍数のうち小さい方を常に参照する。O(min(N, M))で計算可能
        for(int i = 0; i < remain ; i++) {
            if(n2 + n < m2 + m) {
                n2 += n;
            }
            else {
                m2 += m;
            }
        }

        System.out.println(Math.max(n2, m2));
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
