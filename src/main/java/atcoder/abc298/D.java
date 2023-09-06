package atcoder.abc298;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        int mod = 998244353;
        //10, 100, 1000, ...などをmodで割った余りを事前に求めておく
        long powersMod[] = new long[600_001];
        powersMod[1] = 1;
        for(int i = 2; i < powersMod.length; i++) {
            powersMod[i] = powersMod[i - 1] * 10 % mod;
        }

        long current = 1;
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        que.add(1);
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            switch (mode) {
                //末尾に数字を追加するのは乗算と加算だけなのでシンプルにできる
                case (1) -> {
                    int x = sc.nextInt();
                    que.add(x);
                    current = (current * 10 + x) % mod;
                }
                case (2) -> {
                    //例えば54321の先頭の削除は「50000の逆元を加算する」と考える。
                    //事前に求めた余りを使えば桁数が大きくても可能。
                    current = ((mod - powersMod[que.size()]) * que.getFirst() + current) % mod;
                    que.removeFirst();
                }
                case (3) -> {
                    System.out.println(current);
                }
            }
        }
    }
}
