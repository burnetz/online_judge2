
package atcoder.abc471;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        int v = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e2, e1));
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            switch (mode) {
                case 1 -> {
                    long time = sc.nextLong();
                    long remain = sc.nextLong();

                    //どのバッテリーも単位時間あたり1ずつ使用されていたと仮定し
                    //時刻0における残量を記録すると扱いやすい。
                    pq.add(remain - time);
                }
                case 2 -> {
                    long time = sc.nextLong();;

                    if(pq.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(Math.min(v, pq.poll() + time));
                    }

                }
            }
        }
    }
}