package atcoder.abc420;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        //スイッチを押す前後を互いに別世界扱いにするとやりやすい。
        char[][] matrix = new char[h * 2][w];

        int startX = 0;
        int startY = 0;
        for(int i = 0; i < h; i++) {
            String str = sc.next();
            matrix[i] = str.toCharArray();
            matrix[i + h] = str.toCharArray();

            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == 'S') {
                    startX = j;
                    startY = i;
                }

                if(matrix[i + h][j] == 'o') {
                    matrix[i + h][j] = 'x';
                }
                else if(matrix[i + h][j] == 'x') {
                    matrix[i + h][j] = 'o';
                }
            }
        }


        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        ArrayDeque<Point> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[h * 2][w];

        que.add(new Point(startX, startY, 0));
        visited[startY][startX] = true;

        //基本的にはBFSで解く。
        while(!que.isEmpty()) {
            Point tmpPoint = que.removeFirst();

            //Gでさえあればどちらの世界でも良い。
            if(matrix[tmpPoint.y][tmpPoint.x] == 'G') {
                System.out.println(tmpPoint.cost);
                return;
            }


            for(int i = 0; i < 4; i++) {
                int tmpX = tmpPoint.x + dx[i];
                int tmpY = tmpPoint.y + dy[i];


                if(inRange(tmpX, tmpY, h, w, tmpPoint.y >= h) && matrix[tmpY][tmpX] != '#' && matrix[tmpY][tmpX] != 'x') {
                    if(matrix[tmpY][tmpX] == '?') {
                        tmpY = (tmpY + h) % (2 * h);
                    }

                    if(!visited[tmpY][tmpX]) {
                        visited[tmpY][tmpX] = true;
                        que.add(new Point(tmpX, tmpY, tmpPoint.cost + 1));
                    }


                }
            }
        }

        System.out.println(-1);

    }

    //範囲外の判定の仕方に若干注意が必要
    static boolean inRange(int x, int y, int h, int w, boolean isAnotherWorld) {
        if(isAnotherWorld) {
            y -= h;
        }
        return  x >= 0 && x < w && y >= 0 && y < h;
    }
}

class Point {
    int x;
    int y;
    int cost;

    Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}