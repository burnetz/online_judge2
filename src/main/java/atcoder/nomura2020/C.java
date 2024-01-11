package atcoder.nomura2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n + 1]).map(e -> sc.nextInt()).toArray();

        //子持ちノード数の上限と下限
        long up[] = new long[n + 1];
        long bottom[] = new long[n + 1];
        //各階層の子持ちノードの上限と下限を末端から決める。
        for(int i = n; i > 0; i--) {
            //親ノードが子を1つずつしか持たないのが上限
            up[i - 1] = a[i] + up[i];
            //親ノードが子を2つずつ持つのが下限
            bottom[i - 1] = (a[i] + bottom[i] + 1)/2;
        }

        long result = 0;
        //基本的には各階層の上限値を足すのが最適だが
        //存在できるノード数自体に制限があるので考慮する。
        for(int i = 0; i <= n; i++) {
            // オーバーフロー対策。
            // 問題の制約上もup[i]やdown[i]がLongの範囲を超えることはないのでこれで十分
            if(i <= 63) {
                //下限値がその階層に存在しうるノードよりも大きいときは構築不可能
                if( bottom[i] + a[i] > Math.pow(2, i)) {
                    System.out.println(-1);
                    return;
                }
                //上限値がその回数に存在しうるノードよりも大きいときは値を補正
                if(up[i] + a[i] > Math.pow(2, i)) {
                    up[i] = (long)Math.pow(2, i) - a[i];
                }
            }
            if(i >= 1) {
                up[i] = Math.min(up[i], up[i - 1] *2 - a[i]);
            }

            result += up[i] + a[i];
        }

        System.out.println(result);
    }
}
