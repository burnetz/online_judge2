package atcoder.abc383;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int d = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int[][] minDist = new int[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        //やること自体は普通のBFSだが予め全ての加湿器をキューに入れておいた方が無駄がない。
        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        Deque<Tile> que = new ArrayDeque<>();
        for(int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 'H') {
                    minDist[i][j] = 0;
                    que.add(new Tile(j, i, 0));
                }
            }
        }

        while(!que.isEmpty()) {
            Tile tmpTile = que.removeFirst();
            for(int k = 0; k < 4; k++) {
                int tmpX = tmpTile.x + dx[k];
                int tmpY = tmpTile.y + dy[k];
                int tmpDist = tmpTile.dist + 1;

                if(tmpDist <= d && tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h
                        && matrix[tmpY][tmpX] != '#'
                        && minDist[tmpY][tmpX] > tmpDist ){
                    minDist[tmpY][tmpX] = tmpDist;
                    que.add(new Tile(tmpX, tmpY, tmpDist));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(minDist[i][j] <= d) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

class Tile {
    int x;
    int y;
    int dist;

    Tile(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}