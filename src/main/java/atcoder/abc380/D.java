package atcoder.abc380;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            long k = sc.nextLong() - 1;

            //当該インデックスが文字列の前半と後半のどちらにあるかを
            //区間長を半分にしながら繰り返し調べる。
            //後半になる回数が奇数回なら大文字小文字が反転する。
            long divisor = 1;
            while(s.length() * divisor * 2 < k) {
                divisor *= 2;
            }

            int count = 0;
            while (divisor >= 1) {
                if(k >= s.length() * divisor) {
                   count++;
                }

                k %= s.length() * divisor;
                divisor /= 2;
            }

            if(count % 2 == 0) {
                System.out.print(s.charAt((int)k));
            }
            else {
                char c = s.charAt((int)k);

                if(Character.isUpperCase(c)) {
                    System.out.print(Character.toLowerCase(c));
                }
                else {
                    System.out.print(Character.toUpperCase(c));
                }
            }
            System.out.print(" ");
        }
    }
}