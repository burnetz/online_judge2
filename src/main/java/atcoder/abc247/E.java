package atcoder.abc247;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = sc.nextInt();
        int min = sc.nextInt();
        int a[] = new int[n + 1];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[n] = Integer.MAX_VALUE;

        long result = 0;
        int start = -1;
        //最小値と最大値の間に収まらない値は含むことができないので
        //はみ出る値を区切りとして各区間について解く。
        for(int i = 0; i <= n; i++) {
            if(a[i] > max || a[i] < min) {
                if(start >= 0) {
                    result += solve(a, min, max, start, i);
                }
                start = -1;
                continue;
            }

            if(start < 0) {
                start = i;
            }

        }

        System.out.println(result);

    }

    //1つの区間についてあり得るパターン数を計算する。
    static long solve(int[] a, int minValue, int maxValue, int start, int end) {
        long result = 0;

        //最大値や最小値が登場した箇所で最も直近のものを常に参照したいのでスタックを使う。
        Stack<Integer> minPos = new Stack<>();
        Stack<Integer> maxPos = new Stack<>();

        for(int i = start; i < end; i++) {
            if(a[i] == minValue) {
                minPos.push(i);
            }
            if(a[i] == maxValue) {
                maxPos.push(i);
            }

            if(!minPos.isEmpty() && !maxPos.isEmpty()){
                //直近の最大値と最小値のうち先に登場した方のインデックス。
                //これ以前のインデックスなら全て始点になりうる。
                int head = Math.min(minPos.peek(), maxPos.peek());

                result += head - start + 1;
            }
        }
        return  result;
    }
}
