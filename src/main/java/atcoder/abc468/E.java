
package atcoder.abc468;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int mod = 998244353;

        //1からnまでの逆元を準備しておく
        long inv[] = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            inv[i] = repeatablePow(i, mod - 2, mod);
        }

        //平均の計算の際に中間の要素ほど多く出現するので
        //あらかじめa_iからa_{n-i}までの部分和を準備しておく必要がある。
        long partialSum[] = new long[(n + 1) / 2];
        int l, r;
        if(n % 2 == 0) {
            partialSum[n / 2 - 1] = ((long)a[n / 2 - 1] + a[n / 2]) % mod;
            l = n / 2 - 2;
            r = n / 2 + 1;
        }
        else {
            partialSum[n / 2] = a[n / 2];
            l = n / 2 - 1;
            r = n / 2 + 1;
        }

        for(; l >= 0; l--, r++) {
            partialSum[l] = (partialSum[l + 1] + a[l] + a[r]) % mod;
        }

        long result = 0;
        //重複分を考慮した係数の上乗せ分
        int limit = 0;
        long currentSum = partialSum[0];
        for(int i = 1; i <= n; i++) {
            //iが大きくなっても必ず係数の上限が上がるわけではないので注意。
            //nとiが近くなるとかえって自由度が減るため係数の上限が下がる。
            int tmpLimit = Math.min(n - i, i - 1);

            //上限が上がるときも下がるときも1ずつしか変化しない。
            if(tmpLimit > limit) {
                limit++;
                currentSum += partialSum[limit];
                currentSum %= mod;
            }
            else if(tmpLimit < limit) {
                currentSum += mod - partialSum[limit];
                currentSum %= mod;
                limit--;
            }

            result += currentSum * inv[i];
            result %= mod;
        }

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