package atcoder.abc436;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] matrix = new char[h][w];
        Vector<Point>[] warpPoint = new Vector[128];
        for(int i = 0; i < warpPoint.length; i++) {
            warpPoint[i] = new Vector();
        }

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();

            for(int j = 0; j < w; j++) {
                if(Character.isAlphabetic(matrix[i][j])) {
                    warpPoint[matrix[i][j]].add(new Point(j, i));
                }
            }
        }
        boolean[] warpPointUsed = new boolean[128];

        int[][] cost = new int[h][w];

        for(int i = 0; i < h; i++) {
            Arrays.fill(cost[i], INF);
        }
        cost[0][0] = 0;

        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(0, 0));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        //前半は普通のBFSによる探索
        while(!que.isEmpty()) {
            Point tmpPoint = que.remove();
            if(tmpPoint.x() == w - 1 && tmpPoint.y() == h - 1) {
                System.out.println(cost[tmpPoint.y()][tmpPoint.x()]);
                return;
            }

            int nextCost = cost[tmpPoint.y()][tmpPoint.x()] + 1;

            for(int i = 0; i < 4; i++) {
                int tmpX = tmpPoint.x() + dx[i];
                int tmpY = tmpPoint.y() + dy[i];

                if(isAvailable(tmpX, tmpY, nextCost, matrix, cost)) {
                    que.add(new Point(tmpX, tmpY));
                    cost[tmpY][tmpX] = nextCost;
                }
            }

            //ワープポイント関連
            if(Character.isAlphabetic(matrix[tmpPoint.y()][tmpPoint.x()])) {
                char c = matrix[tmpPoint.y()][tmpPoint.x()];

                //一度でもワープに使用したアルファベットは以後検証不要。
                //使うなら最短のターン数で使っているはずだし、毎回検証するとおそらくTLEになる。
                if(!warpPointUsed[c]) {
                    for(int i = 0; i < warpPoint[c].size(); i++) {
                        Point tmpPoint2 = warpPoint[c].elementAt(i);

                        if(isAvailable(tmpPoint2.x(), tmpPoint2.y(), nextCost, matrix, cost)) {
                            warpPointUsed[c] = true;
                            que.add(new Point(tmpPoint2.x(), tmpPoint2.y()));
                            cost[tmpPoint2.y()][tmpPoint2.x()] = nextCost;
                        }
                    }
                }
            }
        }

        System.out.println(-1);

    }

    static int INF = 1_000_000_000;

    static boolean isAvailable(int x, int y, int nextCost, char[][] matrix, int[][] cost) {
        int h = matrix.length;
        int w = matrix[0].length;

        return inRange(x, y, h, w) && matrix[y][x] != '#' && nextCost < cost[y][x];
    }

    static boolean inRange(int x, int y, int h, int w) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}

record Point(int x, int y) {

}