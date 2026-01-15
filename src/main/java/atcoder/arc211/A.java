package atcoder.arc211;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            solve(sc);
        }


    }

    static void solve(Scanner sc) {
        long[] a = Arrays.stream(new long[9]).map(e -> sc.nextInt()).toArray();

        long count5 = a[4];
        long sum = Arrays.stream(a).sum();

        long result = 0;
        //数字をシンプルに昇順に並べることを基本とし５の個数で場合分けする。

        //5が複数ある場合、5の間に適当な数字を挟み込むよう調整する
        if (count5 >= 2) {
            //5以外の数字が足りないなら追加するしかない。
            long except5 = sum - count5;
            result = Math.max(0, count5 - 1 - except5);
        }
        //5が1つだけなら何もしなくて良い。
        else if(count5 == 1) {
            result = 0;
        }
        //5が１つも無い場合、足して10になるある特定の1組の数字だけで構成されているときが要注意。
        //ただし、その場合でも昇順に並んでいる限り適当な数字を1個追加すればOK
        else {
            for(int i = 0; i < 4; i++) {
                if(a[i] + a[8 - i] == sum && a[i] > 0 && a[8 - i] > 0) {
                    result = 1;
                    break;
                }
            }

        }

        System.out.println(result);
    }

}
