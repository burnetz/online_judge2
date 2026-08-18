
package atcoder.abc471;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int mod = 998244353;

        //実際にn=3,4などで手計算すれば規則性は見つかるが
        //mod板のcombinationを計算する必要がある。
        fact = new long[n + 1];
        factInv = new long[n + 1];

        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }

        factInv[n] = repeatablePow((int)fact[n], mod - 2, mod);
        for(int i = n - 1; i >= 0; i--) {
            factInv[i] = factInv[i + 1] * (i + 1) % mod;
        }

        int a[] = Arrays.stream(new int[n]).map(e ->sc.nextInt()).toArray();

        if(n == 1) {
            System.out.println((long)a[0] * a[0] % mod);
            return;
        }

        // nとkがどのような値であっても
        // 各要素の2乗の和と、異なる2要素の積の和があれば計算可能
        long squareSum = 0;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            squareSum += (long) a[i] * a[i];
            squareSum %= mod;
            sum += a[i];
            sum %= mod;
        }

        long pairSum = (sum * sum % mod + (mod - squareSum)) % mod * factInv[2] % mod;

        long result = combination(n - 1, k - 1, mod) * squareSum % mod;
        if(k >= 2) {
            result += combination(n - 2, k - 2, mod) * 2 * pairSum;
            result %= mod;
        }

        System.out.println(result);
    }

    static long[] fact;
    static long[] factInv;

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

    static long combination(int n, int k, int mod) {
        return fact[n] * factInv[k] % mod * factInv[n - k] % mod;
    }

}