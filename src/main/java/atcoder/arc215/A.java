package atcoder.arc215;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int streetLength = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();
        int leftMargin = a[0];
        int rightMargin = streetLength - a[n - 1];

        //初期状態でのゾンビとゾンビの間の距離を降順に保存する。具体的な座標は不要
        PriorityQueue<Integer> que = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        for(int i = 0; i < n - 1; i++) {
            que.add(a[i + 1] - a[i]);
        }

        //内側で餌を使わない場合、右端と左端を行ったり来たりさせるのが最善
        long result = Math.max(leftMargin, rightMargin) + (long)(k - 1) * (leftMargin + rightMargin);

        long innerMoveTime = 0;
        //内側に餌を置いた場合、置かれた区間の間隔は変化するが他の区間の距離の変化やゾンビの前後交代などは起きない。
        //区間内に置くとしたら最も広い区間の真ん中に置くべきなので、その都度左端と右端がどう変わるか計算すれば良い。
        for(int i = 1; i <= k && !que.isEmpty(); i++) {
            int tmp = que.remove();

            leftMargin += tmp / 2;
            rightMargin += tmp / 2;
            innerMoveTime += tmp / 2;

            long tmpResult = innerMoveTime;
            //以下、現時点で余った餌を全て左右に振り回すのに使った場合の結果を計算。
            if(k - i >= 1) {
                tmpResult += Math.max(leftMargin, rightMargin);
            }
            if(k - i >= 2) {
                tmpResult += (long)(k - i - 1) * (leftMargin + rightMargin);
            }

            result = Math.max(result, tmpResult);
        }

        System.out.println(result);


    }
}