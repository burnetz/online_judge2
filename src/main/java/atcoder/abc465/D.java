
package atcoder.abc465;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        long x = sc.nextLong();
        long y = sc.nextLong();
        long k = sc.nextLong();

        //xとyをそれぞれk進数表示として考えると分かりやすい。
        //そのために係数を取り出す。
        Deque<Long> queX = new ArrayDeque<>();
        Deque<Long> queY = new ArrayDeque<>();

        long copyX = x;
        while(copyX > 0) {
            queX.addFirst(copyX % k);
            copyX /= k;
        }
        long copyY = y;
        while(copyY > 0) {
            queY.addFirst(copyY % k);
            copyY /= k;
        }

        //Dequeだと少し使いづらいのでVectorに移し替える。
        //もちろん最初からVectorでも良い。
        Vector<Long> vecX = new Vector<>();
        Vector<Long> vecY = new Vector<>();
        while(!queX.isEmpty()) {
            vecX.add(queX.removeFirst());
        }
        while(!queY.isEmpty()) {
            vecY.add(queY.removeFirst());
        }

        //次数の高い方から何桁目までは係数が一致しているかを調べる。
        int same = 0;
        for(int i = 0; i < Math.min(vecX.size(), vecY.size()) ; i++) {
            if(!vecX.elementAt(i).equals(vecY.elementAt(i))) {
                break;
            }
            same++;
        }

        //xをyに合わせるには、係数が合わなくなるところを全て右シフトで消した上で
        //左シフト時に好きな剰余項を補えば良い。
        //xとyのどちらが桁数が大きくても同じ計算式になる。
        int result = vecX.size() - same + vecY.size() - same;

        System.out.println(result);
    }
}