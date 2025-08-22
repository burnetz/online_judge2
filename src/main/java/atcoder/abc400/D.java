package atcoder.abc400;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int startR = sc.nextInt() - 1;
        int startC = sc.nextInt() - 1;
        int goalR = sc.nextInt() - 1;
        int goalC = sc.nextInt() - 1;

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        int cost[][] = new int[h][w];
        int INF = 1_000_000_000;
        for(int i = 0; i < h; i++) {
            Arrays.fill(cost[i], INF);
        }
        Deque<Point> que1 = new ArrayDeque<>();
        Deque<Point> que2 = new ArrayDeque<>();
        cost[startR][startC] = 0;
        que1.add(new Point(startR, startC, 0));

        //大まかにはBFSだが、壁を壊さずに移動するためのwhileと
        //壁を壊すためのwhileを明確に分けたほうが良い。
        //混ぜるとキューの中身がコスト順であることが保証できなくなる。
        while(true) {
            //壁を壊さないwhile, 未訪問のマスをque2に入れて蹴りの起点にする。
            while (!que1.isEmpty()) {
                Point tmpPoint = que1.removeFirst();

                if (tmpPoint.r == goalR && tmpPoint.c == goalC) {
                    System.out.println(tmpPoint.cost);
                    return;
                }

                que2.add(tmpPoint);

                for (int i = 0; i < 4; i++) {
                    int tmpR = tmpPoint.r + dy[i];
                    int tmpC = tmpPoint.c + dx[i];

                    if (inRange(tmpR, tmpC, h, w) && cost[tmpR][tmpC] == INF && matrix[tmpR][tmpC] == '.') {
                        cost[tmpR][tmpC] = tmpPoint.cost;
                        que1.add(new Point(tmpR, tmpC, tmpPoint.cost));
                    }
                }
            }

            //蹴りを行うためのwhileループ。
            //ここではコストが1増える。
            //壁を壊した後に移動できるマスがあったとしてもそれは前半のループに任せる。
            while (!que2.isEmpty()) {
                Point tmpPoint = que2.removeFirst();

                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j <= 2; j++) {
                        int tmpR = tmpPoint.r + dy[i] * j;
                        int tmpC = tmpPoint.c + dx[i] * j;

                        if (inRange(tmpR, tmpC, h, w) && cost[tmpR][tmpC] == INF && matrix[tmpR][tmpC] == '#') {
                            matrix[tmpR][tmpC] = '.';
                            que1.add(new Point(tmpR, tmpC, tmpPoint.cost + 1));
                        }
                    }
                }
            }
        }
    }

    static boolean inRange(int r, int c, int h, int w) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}

class Point {
    int r;
    int c;
    int cost;

    Point(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}