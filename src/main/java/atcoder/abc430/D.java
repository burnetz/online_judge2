package atcoder.abc430;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long result = 0;
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(0);
        //数字は必ず右端か内側に挿入される。
        //挿入する数字を基準に左右2個ずつ数字を見れば全てのパターンを網羅できる。
        //なお、値を探すだけなら良いが毎回左右のビューを分けて取得するとTLEになる。
        for(int i = 0; i < n; i++) {
            Integer lowerTop = navigableSet.lower(a[i]);
            Integer upperBottom = navigableSet.higher(a[i]);

            //右端に挿入されるパターン
            if(upperBottom == null) {
                int d1Inside = Integer.MAX_VALUE;

                Integer lowerTop2 = navigableSet.lower(lowerTop);
                //a[i]よりも小さい数字が2つ以上あるパターン
                if(lowerTop2 != null) {
                    d1Inside = lowerTop - lowerTop2;
                }

                if(d1Inside < Integer.MAX_VALUE) {
                    result -= d1Inside;
                }
                result += Math.min(a[i] - lowerTop, d1Inside);

                result += a[i] - lowerTop;
            }
            //内側に挿入されるパターン
            else {
                int d1d2 = upperBottom - lowerTop;
                int d1Inside = Integer.MAX_VALUE;
                int d2Inside = Integer.MAX_VALUE;

                Integer lowerTop2 = navigableSet.lower(lowerTop);
                Integer upperBottom2 = navigableSet.higher(upperBottom);

                //a[i]より小さい数字が2つ以上あるパターン
                if(lowerTop2 != null) {
                    d1Inside = lowerTop - lowerTop2;
                }

                //a[i]より大きい数字が2つ以上あるパターン
                if(upperBottom2 != null) {
                    d2Inside = upperBottom2 - upperBottom;
                }

                result -= Math.min(d1d2, d1Inside);
                result -= Math.min(d1d2, d2Inside);
                result += Math.min(a[i] - lowerTop, upperBottom - a[i]);
                result += Math.min(a[i] - lowerTop, d1Inside);
                result += Math.min(upperBottom - a[i], d2Inside);

            }
            navigableSet.add(a[i]);
            System.out.println(result);
        }
    }
}