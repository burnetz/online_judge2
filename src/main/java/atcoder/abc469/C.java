
package atcoder.abc469;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = sc.next();

        int current = 0;
        for(int i = 0; i < n; i++) {
            if(current == n) {
                System.out.println(n);
                continue;
            }

            //毎回無関係なクエリに答えるタイプの問題だと当たり続けたパターンでTLEになる可能性があるが
            //問われているkが小さい順であり無駄な計算が発生しないので素直に計算して良い。
            int extra = 0;
            if(str.charAt(current) == 'o') {
                extra = 1;
            }
            current++;
            while (extra > 0 && current < n) {
                if(str.charAt(current) == 'x') {
                    extra--;
                }
                current++;
            }

            System.out.println(current);
        }
    }
}