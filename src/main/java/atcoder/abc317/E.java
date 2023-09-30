package atcoder.abc317;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        visited = new boolean[h][w];
        matrix = new char[h][w];
        Point start = null;
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == 'S') {
                    start = new Point(j, i, 0);
                }
            }
        }

        //視界の処理を事前におこなっておく。O(HW)なので間にあう。
        for(int i = 0; i < h; i++) {
            boolean inSight = false;
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '>') {
                    inSight = true;
                }
                else if(isObject(matrix[i][j] )) {
                    inSight = false;
                }
                else if(inSight) {
                    matrix[i][j] = '!';
                }
            }
        }

        for(int i = 0; i < h; i++) {
            boolean inSight = false;
            for(int j = w - 1; j >= 0; j--) {
                if(matrix[i][j] == '<') {
                    inSight = true;
                }
                else if(isObject(matrix[i][j] )) {
                    inSight = false;
                }
                else if(inSight) {
                    matrix[i][j] = '!';
                }
            }
        }

        for(int i = 0; i < w; i++) {
            boolean inSight = false;
            for(int j = 0; j < h; j++) {
                if(matrix[j][i] == 'v') {
                    inSight = true;
                }
                else if(isObject(matrix[j][i] )) {
                    inSight = false;
                }
                else if(inSight) {
                    matrix[j][i] = '!';
                }
            }
        }

        for(int i = 0; i < w; i++) {
            boolean inSight = false;
            for(int j = h - 1; j >= 0; j--) {
                if(matrix[j][i] == '^') {
                    inSight = true;
                }
                else if(isObject(matrix[j][i] )) {
                    inSight = false;
                }
                else if(inSight) {
                    matrix[j][i] = '!';
                }
            }
        }

        //BFS
        Deque<Point> que = new ArrayDeque<>();
        visited[start.y][start.x] = true;
        que.add(start);

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        while(!que.isEmpty()) {
            Point p = que.removeFirst();

            if(matrix[p.y][p.x] == 'G'){
                System.out.println(p.dist);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int tmpX = p.x + dx[i];
                int tmpY = p.y + dy[i];

                if(inRange(tmpX, tmpY, h, w) && !isDenied(matrix[tmpY][tmpX]) && !visited[tmpY][tmpX]){
                    visited[tmpY][tmpX] = true;
                    que.add(new Point(tmpX, tmpY, p.dist + 1));
                }
            }
        }
        System.out.println(-1);

    }

    //障害物または人か。視界内かどうかは考えない。
    static boolean isObject(char c) {
        return c == '#' || c == '^' || c == 'v' || c == '>' || c == '<' ;
    }

    //視線上も含め通れない場合true
    static boolean isDenied(char c) {
        return isObject(c) || c == '!';
    }

    static boolean inRange(int x, int y, int h, int w) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }

    static char[][] matrix;
    static boolean[][] visited;
}

class Point {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}