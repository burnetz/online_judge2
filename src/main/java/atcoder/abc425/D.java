package atcoder.abc425;

import java.util.ArrayDeque;
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

        int[][] timestamp = new int[h][w];
        Deque<Point> que1 = new ArrayDeque<>();
        int count = 0;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '.') {
                    timestamp[i][j] = -1;
                }
                else {
                    timestamp[i][j] = 0;
                    que1.add(new Point(j, i, 0));
                    count++;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        //BFSの要領で、なおかつ1ターンごとに処理を進める。
        for(int i = 0; ; i++) {
            if(que1.isEmpty()) {
                break;
            }

            while(!que1.isEmpty()) {
                if(que1.getFirst().timestamp > i) {
                    break;
                }

                Point tmpPoint = que1.removeFirst();

                for(int j = 0; j < 4; j++) {
                    int tmpX = tmpPoint.x + dx[j];
                    int tmpY = tmpPoint.y + dy[j];

                    if(inRange(tmpX, tmpY, h, w) && timestamp[tmpY][tmpX] == -1) {
                        int blackCount = 0;
                        for(int k = 0; k < 4; k++) {
                            int tmpX2 = tmpX + dx[k];
                            int tmpY2 = tmpY + dy[k];

                            //周辺の黒いマスの数を数える。
                            //最後の条件がないと同じターン内で染めた黒もカウントしてしまう。
                            if(inRange(tmpX2, tmpY2, h, w) && timestamp[tmpY2][tmpX2] >= 0 && timestamp[tmpY2][tmpX2] <= i) {
                                blackCount++;
                            }
                        }
                        if(blackCount == 1) {
                            que1.add(new Point(tmpX, tmpY, i + 1));
                            timestamp[tmpY][tmpX] = i + 1;
                            count++;
                        }

                    }
                }

            }

        }

        System.out.println(count);
    }

    static boolean inRange(int x, int y, int h, int w) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}

class Point {
    int x;
    int y;
    int timestamp;


    public Point(int x, int y, int timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }
}