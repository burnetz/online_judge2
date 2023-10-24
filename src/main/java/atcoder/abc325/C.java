package atcoder.abc325;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }
        visited = new boolean[h][w];

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#' && !visited[i][j]) {
                    dfs(j, i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static char[][] matrix;
    static boolean[][] visited;

    static void dfs(int x, int y) {
        visited[y][x] = true;

        int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

        int h = matrix.length;
        int w = matrix[0].length;

        for(int i = 0; i < 8; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && !visited[tmpY][tmpX] && matrix[tmpY][tmpX] == '#') {
                dfs(tmpX, tmpY);
            }
        }
    }
}
