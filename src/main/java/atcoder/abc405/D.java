package atcoder.abc405;

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

        //BFSで解けるが出口が複数もしくは0個もありえるので注意
        Deque<Tile> que = new ArrayDeque<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == 'E') {
                    Tile exit = new Tile(j, i);
                    que.add(exit);
                }
            }
        }

        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        char arrow[] = {'^', '<', 'v', '>'};

        while (!que.isEmpty()) {
            Tile tmpTile = que.removeFirst();

            for (int i = 0; i < 4; i++) {
                int tmpX = tmpTile.x + dx[i];
                int tmpY = tmpTile.y + dy[i];

                //元々の盤面自体書き換えて良い
                if (inRange(h, w, tmpX, tmpY) && matrix[tmpY][tmpX] == '.') {
                    matrix[tmpY][tmpX] = arrow[i];
                    que.add(new Tile(tmpX, tmpY));
                }
            }
        }

        for(int i = 0; i < h; i++) {
            System.out.println(matrix[i]);
        }
    }

    static boolean inRange(int h, int w, int x, int y) {
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}

class Tile {
    int x;
    int y;

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}