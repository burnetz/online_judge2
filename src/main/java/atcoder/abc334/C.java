package atcoder.abc334;

import java.util.*;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(k == 1) {
            System.out.println(0);
            return;
        }

        int a[] = Arrays.stream(new int[k]).map(e -> sc.nextInt() - 1).toArray();

        //最適なパターンであればもともと組ができている靴下はそのままなので
        //片方しかない靴下のみの数列で考える。
        //2要素ごとの距離の和を順方向と逆方向で作っておく。
        int forwardSum[] = new int[k + 1];
        int backSum[] = new int[k + 2];
        for(int i = 1; i + 1 <= k; i += 2) {
            forwardSum[i] = forwardSum[i - 1] + a[i] - a[i - 1];
            forwardSum[i + 1] = forwardSum[i];
        }
        for(int i = k ; i >= 2; i -= 2) {
            backSum[i] = backSum[i + 1] + a[i - 1] - a[i - 2];
            backSum[i - 1] = backSum[i];
        }

        //片方のみの靴下が偶数なら累積和自体が答えになる
        if((2*n - k) % 2 == 0) {
            System.out.println(forwardSum[k]);
        }

        else {
            int result = Integer.MAX_VALUE;
            //i番目を抜いたときの和を求める。
            //なお、奇数番目を抜くパターンしか最適にならない。
            //（偶数番目を抜くと綺麗に前後のグループに分かれずつなぎ目の部分が大きな値になる）
            for(int i = 1; i <= k; i += 2) {
                int tmp = forwardSum[i - 1] + backSum[i + 1];
                result = Math.min(tmp, result);
            }

            System.out.println(result);
        }
    }
}