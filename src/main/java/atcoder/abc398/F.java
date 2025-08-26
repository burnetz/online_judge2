package atcoder.abc398;

import java.util.Arrays;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int length = s.length();

        int mod = 1_000_000_007;
        long hash1 = 0;
        long hash2 = 0;

        //回分の長さの初期値は元の文字列を逆にして結合させただけの長さとする。
        //本当は1文字は確実に減らせるがこのほうが下のループがわかりやすい。
        int resultLength = 2 * length;
        long geta = 1;

        //元の文字列と逆にした文字列の重複部分が長いほど最終的な文字列は短くなる。
        //同じ文字列かどうかの判定は簡易ハッシュを用いる。シンプルだがACできる。
        for(int i = 0; i < length; i++) {
            //前後のどちらに1文字追加するかによって計算式が変わるので注意
            hash1 = (hash1 * 26 + (s.charAt(length - i - 1) - 'A')) % mod;
            hash2 = (hash2 + (s.charAt(length - i - 1) -  'A') * geta) % mod;

            if(hash1 == hash2) {
                resultLength = 2 * length - i - 1;
            }

            geta = (geta * 26) % mod;
        }

        StringBuffer sb = new StringBuffer(s.substring(0, resultLength - length)).reverse();
        System.out.println(s + sb);

    }
}