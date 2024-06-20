package atcoder.abc357;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        int mod = 998244353;

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int length = str.length();
        long n = Long.parseLong(str);

        //nよりも1桁大きい10のべき乗を求める。
        //n=10^18の場合、途中でmodを取らないとオーバーフローするので注意。
        long pow10 = 1;
        for(int i = 0; i < length; i++) {
            pow10 *= 10;
            pow10 %= mod;
        }
        int r = (int)pow10;

        //等比級数の和として計算できる。割り算は(r-1)の逆元をフェルマーの小定理で求める。
        //とにかく途中でのオーバーフローに気をつける。
        //なお、公式内のr^nのnの部分はmodを考えてはいけない。
        long result = n % mod * (repeatablePow(r, n, mod) + mod - 1) % mod * repeatablePow((int)(((long)r + mod - 1)%mod), mod - 2, mod) % mod;

        System.out.println(result);

    }

    static long repeatablePow(int x, long n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }
}