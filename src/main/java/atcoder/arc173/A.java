package atcoder.arc173;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        nines = new long[NINES_MAX];
        nines[0] = 1;
        for(int i = 1; i < NINES_MAX; i++) {
            nines[i] = nines[i - 1] * 9;
        }

        for(int i = 0; i < t; i++) {
            long n = sc.nextLong();

            solve(n);
        }
    }

    static long[] nines;
    static int NINES_MAX = 20;

    /**
     * 桁ごとに使える数字が異なるが基本的には9進数のつもりで考える
     */
    static void solve(long n) {
        int digits = 0;
        //まずは桁数を確定させる。
        for(int i = 1; ; i++) {
            if(n <= 9*(nines[i] - 1)/8) {
                digits = i;
                break;
            }
        }

        String result = "";

        //分かりやすいように(digits - 1)桁以下の数字を無いものとして扱う。
        //また、0オリジンの方が計算しやすい。
        n -= 9*(nines[digits - 1] - 1)/8;
        n--;
        for(int i = digits; i >= 1; i--) {
            int tmp = (int)(n / nines[i - 1]);

            //最初の桁は0を使えないので一律で1加算
            if(i == digits) {
                result += tmp + 1;
            }
            //使用不可の数字以上のときは1加算
            else if(tmp >= result.charAt(result.length() - 1) - '0'){
                result += tmp + 1;
            }
            else {
                result += tmp;
            }

            n %= nines[i - 1];
        }

        System.out.println(result);
    }

}
