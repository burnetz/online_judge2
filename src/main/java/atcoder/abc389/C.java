package atcoder.abc389;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        ArrayList<Snake> que = new ArrayList<>();
        long offset = 0;

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            long lastTail = 0;
            if(!que.isEmpty()) {
                lastTail = que.get(que.size() - 1).headPos + que.get(que.size() - 1).length;
            }

            switch (mode) {
                case 1 -> {
                    long tmp = sc.nextLong();
                    Snake snake = new Snake(lastTail, tmp);
                    que.add(snake);
                }
                case 2 -> {
                    Snake snake = que.remove(0);
                    offset += snake.length;
                }
                case 3 -> {
                    Snake snake = que.get(sc.nextInt() - 1);
                    System.out.println(snake.headPos - offset);
                }
            }
        }
    }
}

class Snake {
    long headPos;
    long length;

    Snake(long headPos, long length) {
        this.headPos = headPos;
        this.length = length;
    }

}