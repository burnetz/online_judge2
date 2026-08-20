package atcoder.abc453;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            String tmp = sc.next();
            matrix[i] = tmp.toCharArray();
        }

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }

        Queue<Info> que = new ArrayDeque<>();
        //決まった方向しか入ることができない4つの盤面があると考えると解きやすい。
        boolean visited[][][] = new boolean[4][h][w];
        visited[0][startY][startX] = true;
        que.add(new Info(-1, startX, startY));
        int[][][] fromHistory = new int[4][h][w];

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        char dir[] = {'U', 'R', 'D', 'L'};
        while(!que.isEmpty()) {
            Info tmpInfo = que.remove();

            //ルートの復元のためには予め「どのレイヤーからこのマスに来たか」という履歴を保存しておく必要がある。
            //一方、「どの方向から来たか」は自分の所属レイヤーで判断できる。
            if(matrix[tmpInfo.y()][tmpInfo.x()] == 'G') {
                System.out.println("Yes");
                int currentX = tmpInfo.x();
                int currentY = tmpInfo.y();
                int currentDir = tmpInfo.dir();

                StringBuilder sb = new StringBuilder();
                while (true) {
                    sb.append(dir[currentDir]);
                    int nextDir = fromHistory[currentDir][currentY][currentX];

                    switch (currentDir) {
                        case 0 -> {
                            currentY++;
                        }
                        case 1 -> {
                            currentX--;
                        }
                        case 2 -> {
                            currentY--;
                        }
                        case 3 -> {
                            currentX++;
                        }
                    }
                    if(currentX == startX && currentY == startY) {
                        break;
                    }

                    currentDir = nextDir;
                }

                System.out.println(sb.reverse());

                return;
            }

            char type = matrix[tmpInfo.y()][tmpInfo.x()];

            for(int i = 0; i < 4; i++) {
                int from = tmpInfo.dir();
                //着目しているマスの種類によって制約が異なる。
                if(type == 'o' && i != from) {
                    continue;
                }
                if(type == 'x' && from == i) {
                    continue;
                }

                int tmpX = tmpInfo.x() + dx[i];
                int tmpY = tmpInfo.y() + dy[i];

                if(!inRange(tmpX, tmpY, h, w)) {
                    continue;
                }

                if(!visited[i][tmpY][tmpX] && matrix[tmpY][tmpX] != '#') {
                    visited[i][tmpY][tmpX] = true;
                    fromHistory[i][tmpY][tmpX] = from;
                    que.add(new Info(i, tmpX, tmpY));
                }
            }
        }

        System.out.println("No");
    }

    static boolean inRange(int x, int y, int h, int w) {
        return  x >= 0 && x < w && y >= 0 && y < h;
    }
}

record Info(int dir, int x, int y) {}