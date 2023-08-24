package atcoder.abc311;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] matrix = new char[n][m];

        for(int i = 0; i < n; i++){
            matrix[i] = sc.next().toCharArray();
        }

        //通過したかどうかとは別に停止したかを管理したほうが良い
        boolean[][] passed = new boolean[n][m];
        boolean[][] stopped = new boolean[n][m];

        Deque<Point> que = new ArrayDeque<Point>();

        passed[1][1] = true;
        stopped[1][1] = true;
        que.add(new Point(1, 1));

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        //BFS
        while(!que.isEmpty()) {
            Point tmpPoint = que.removeFirst();

            for(int i = 0; i < 4; i++){
                int tmpX = tmpPoint.x + dx[i];
                int tmpY = tmpPoint.y + dy[i];
                int lastX = -1;
                int lastY = -1;
                //同じ方向に滑り続けるのでここがいつものBFSとは異なる。
                while(isBlank(tmpX, tmpY, n, m, matrix)) {
                    passed[tmpY][tmpX] = true;
                    lastX = tmpX;
                    lastY = tmpY;
                    tmpX += dx[i];
                    tmpY += dy[i];
                }

                if(lastX >= 0) {
                    //止まった場所が既に探索の起点になったことがあるなら無視。
                    //これがないと無限ループになる。
                    if(stopped[lastY][lastX]) {
                        continue;
                    }

                    stopped[lastY][lastX] = true;
                    que.add(new Point(lastX, lastY));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(passed[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean isBlank(int x, int y, int n, int m, char[][] matrix){
        return x >= 0 && x < m && y >= 0 && y < n && matrix[y][x] == '.';
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}