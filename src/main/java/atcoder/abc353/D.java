package atcoder.abc353;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        int mod = 998244353;

        long sum[] = new long[n];
        long base10Sum[] = new long[n];
        sum[n - 1] = a[n - 1] % mod;
        //例えば3,14の連結は300 + 14と解釈できる。
        //これを利用して後ろの数字の文字数の和をメモすることで高速化できる。
        base10Sum[n - 1] = (long)Math.pow(10, digits(a[n - 1])) % mod;
        for(int i = n - 2; i >= 0; i--) {
            base10Sum[i] = (base10Sum[i + 1] + (long)Math.pow(10, digits(a[i]))) % mod;
            sum[i] = (sum[i + 1] + a[i]) % mod;
        }

        long result = 0;
        for(int i = 0; i < n - 1; i++) {
            result += a[i] * base10Sum[i + 1] + sum[i + 1];
            result %= mod;
        }

        System.out.println(result);


    }

    static int digits(long a) {
        return Long.toString(a).length();
    }
}