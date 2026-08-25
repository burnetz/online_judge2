
package atcoder.abc472;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        char[][] matrix = new char[h][w];

        boolean dangerCol[] = new boolean[w];
        boolean dangerRow[] = new boolean[h];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();

            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#') {
                    dangerRow[i] = true;
                    dangerCol[j] = true;
                }
            }
        }

        int INF = 1_000_000_000;

        Queue<Point> que = new ArrayDeque<>();
        int[][] dist = new int[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(dist[i], INF);
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(!dangerRow[i] && !dangerCol[j]) {
                    que.add(new Point(j, i, 0));
                    dist[i][j] = 0;
                }

            }
        }

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        //やるべきことは普通のBFS。HW<=5*10^5の制約のおかげで適切に制御すれば間に合う。
        while(!que.isEmpty()) {
            Point tmpPoint = que.remove();

            for(int i = 0; i < 4; i++) {
                int tmpX = tmpPoint.x() + dx[i];
                int tmpY = tmpPoint.y() + dy[i];
                if(inRange(tmpX, tmpY, h, w) && matrix[tmpY][tmpX] == '.') {
                    int tmpDist = tmpPoint.dist() + 1;

                    //今回の問題では距離がkより大きくなるパターンは調べる必要がない。
                    if(tmpDist <= k && dist[tmpY][tmpX] > tmpDist) {
                        dist[tmpY][tmpX] = tmpDist;
                        que.add(new Point(tmpX, tmpY, tmpDist));
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(dist[i][j] <= k) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    static boolean inRange(int x, int y, int h, int w) {
        return  x >= 0 && x < w && y >= 0 && y < h;
    }
}

record Point(int x, int y, int dist) {}