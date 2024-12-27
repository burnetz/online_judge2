package atcoder.abc379;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        //植えられた時刻をキューで管理する。
        //伐採したあとにソートし直さなくても必ず小さい順になる。
        Deque<Long> que = new ArrayDeque<>();
        long time = 0;
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    que.add(time);
                }
                case 2 -> {
                    time += sc.nextInt();
                }
                case 3 -> {
                    long h = sc.nextLong();
                    int count = 0;
                    while(!que.isEmpty() && time - que.getFirst() >= h) {
                        que.removeFirst();
                        count++;
                    }

                    System.out.println(count);
                }
            }
        }
    }
}
