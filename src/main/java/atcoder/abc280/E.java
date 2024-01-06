package atcoder.abc280;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n == 1) {
            System.out.println(1);
            return;
        }
        int p = sc.nextInt();
        int mod = 998244353;

        //combinationの計算を行うためにあらかじめ階乗およびその逆数を計算しておく必要がある。
        fact = new long[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) {
            fact[i] = (long)i * fact[i - 1] % mod;
        }
        factReverse = new long[n + 1];
        factReverse[n] = repeatablePow((int)fact[n], mod - 2, mod);

        for(int i = n - 1; i >= 0; i--) {
            factReverse[i] = factReverse[i + 1] * (i + 1) % mod;
        }

        //通常ヒットおよびクリティカルの確率をmodで表す。
        long by100 = repeatablePow(100, mod - 2, mod);
        long pHit = (100 - p) * by100 % mod;
        long pCritical = p * by100 % mod;

        long result = 0;

        //i回の攻撃で倒す
        for(int i = n; i >= n / 2; i--) {
            //最後がぴったり
            int critNum = n - i;
            int hitNum = i - critNum;
            if(critNum >= 0 && hitNum >= 0){
                result += repeatablePow((int)pHit, hitNum, mod) % mod * repeatablePow((int)pCritical, critNum, mod) % mod * combination(i , critNum, mod) % mod * i % mod;
            }

            //最後がオーバーキル
            critNum = (n - 1) - (i - 1);
            hitNum = i - 1 - critNum;
            if(critNum >= 0 && hitNum >= 0){
                //必ず最後がクリティカルなので残りの(i - 1)回について考える。
                result += pCritical * repeatablePow((int)pHit, hitNum, mod) % mod * repeatablePow((int)pCritical, critNum, mod) % mod * combination(i - 1 , critNum, mod) % mod * i % mod;
            }

            result %= mod;
        }
        System.out.println(result);
    }
    static long repeatablePow(int x, int n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }

    static long[] fact, factReverse;

    static int combination(int n, int m, int mod) {
        return (int)(fact[n] * factReverse[m] % mod * factReverse[n - m] % mod);
    }
}
