package atcoder.abc356;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long m = sc.nextLong();

        //1からnまでの間にiビット目が何回1になるか
        long[] one = new long[64];
        long mask = 1L << 62;
        for(int i = 62; i >= 0; i--) {
            //たとえば1XXXXの場合だと
            //10000までに0〜3ビットまでは0と1が均等に発生したことになる。
            //また、4ビット目は1XXXXから10000の間ずっと1だったことになる。
            if((n & mask) != 0) {
                one[i] += n - mask + 1;
                for(int j = i - 1; j >= 0; j--) {
                    one[j] += mask / 2;
                }

            }

            //見るべきところより上位ビットは常に0にする。
            n %= mask;
            mask >>= 1;
        }

        long result = 0;
        int mod = 998244353;
        mask = 1;
        for(int i = 0; i < 63; i++) {
            if((m & mask) != 0) {
                result += one[i];
                result %= mod;
            }

            mask <<= 1;
        }

        System.out.println(result);
    }
}