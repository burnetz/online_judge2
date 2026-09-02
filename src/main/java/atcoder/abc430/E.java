package atcoder.abc430;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static final int mod = 982451653;
    //加法における1の逆元
    static final int minus1 = mod - 1;
    //乗法における2の逆元。1ビットシフトに使う
    static final int div2 = (int)repeatablePow(2, mod - 2, mod);

    static void solve(Scanner sc) {
        String a = sc.next();
        String b = sc.next();

        //与えられた文字列を2進数とみなしたときの値をmodで表したものをハッシュとする。
        long hashA = 0;
        long hashB = 0;
        long multiplier = 1;
        for(int i = 0; i < b.length(); i++) {
            if(a.charAt(i) == '1') {
                hashA += multiplier;
                hashA %= mod;
            }
            if(b.charAt(i) == '1') {
                hashB += multiplier;
                hashB %= mod;
            }
            multiplier *= 2;
            multiplier %= mod;
        }

        for(int i = 0; i < a.length(); i++) {
            //ハッシュが一致する場合は本当に同一であるかをチェックする。
            if(hashA == hashB) {
                boolean isSame = true;

                for(int j = 0; j < a.length(); j++) {
                    if(a.charAt((j + i) % a.length()) != b.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if(isSame) {
                    System.out.println(i);
                    return;
                }
            }

            //見ている数字が1の場合はシフトの前に1を減算すること。
            //modの計算は通常のint型のときと異なり切り捨てされない。
            if(a.charAt(i) == '1') {
                hashA += minus1;
                hashA %= mod;
                hashA *= div2;
                hashA %= mod;
                hashA += repeatablePow(2, a.length() - 1, mod);
                hashA %= mod;

            }
            else {
                hashA *= div2;
                hashA %= mod;
            }
        }

        System.out.println(-1);


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
}