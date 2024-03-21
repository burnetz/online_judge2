
package atcoder.arc174;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            long a[] = Arrays.stream(new long[5]).map(e -> sc.nextInt()).toArray();
            long p[] = Arrays.stream(new long[5]).map(e -> sc.nextInt()).toArray();

            //目標である3を0として不足分と余剰分を数える。
            long minus = a[0] * 2 + a[1];
            long plus = a[3] + a[4] * 2;

            long require = Math.max(0, minus - plus);

            long result = 0;
            //4と5以外のレビューを増やす意味はないので
            //あとはそのうちどちらが得であるかを考える。

            //4のレビュー2件の方が5が1件よりも安いパターン。5を選ぶ意味が無い。
            if(p[3]*2 <= p[4]) {
                result = require * p[3];
            }
            else {
                result = require / 2 * p[4];

                //端数分を考える。4よりも5の1件の方が得なパターンも考える。
                if(require % 2 == 1) {
                    result += Math.min(p[3], p[4]);
                }
            }

            System.out.println(result);
        }
    }


}
