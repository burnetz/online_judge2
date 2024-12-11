package atcoder.abc378;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        visited = new boolean[h][w];

        int result = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(!isAvailable(j, i)) {
                    continue;
                }

                visited[i][j] = true;
                result += dfs(j, i, 0, k);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    static char matrix[][];
    static boolean visited[][];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int dfs(int x, int y, int currentDepth, int maxDepth) {
//        for(int i = 0; i < currentDepth ; i++) {
//            System.out.print(" ");
//        }
//        System.out.println("(" + x + ", " + y + ")");


        if(currentDepth == maxDepth) {
            return 1;
        }

        int result = 0;

        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(!isAvailable(tmpX, tmpY)) {
                continue;
            }

            visited[tmpY][tmpX] = true;
            result += dfs(tmpX, tmpY, currentDepth + 1, maxDepth);
            visited[tmpY][tmpX] = false;
        }

        return result;
    }

    static boolean inRange(int x, int y) {
        return  x >= 0 && y >= 0 && x < matrix[0].length && y < matrix.length;
    }

    static boolean isAvailable(int x, int y) {
        return inRange(x, y) && !visited[y][x] && matrix[y][x] == '.';
    }
}