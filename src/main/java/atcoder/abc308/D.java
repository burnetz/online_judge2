package atcoder.abc308;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        matrix = new char[h][w];
        visited = new boolean[h][w];

        for(int i = 0; i < h; i++){
            matrix[i] = sc.next().toCharArray();
        }

        if(matrix[0][0] == 's') {
            dfs(0, 0, 0);
        }

        System.out.println("No");
    }

    static char[][] matrix;
    static boolean[][] visited;
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {-1,0,1,0};

    static final char[] snuke = "snuke".toCharArray();

    //条件を守ってゴールにたどり着けるかDFSで判定
    static void dfs(int depth, int x, int y){
        int h = matrix.length;
        int w = matrix[0].length;

        if(x == w - 1 && y == h - 1){
            System.out.println("Yes");
            System.exit(0);
        }

        char nextChar = snuke[(depth + 1) % 5];
        for(int i = 0; i < 4; i++){
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == nextChar && !visited[tmpY][tmpX]){
                visited[tmpY][tmpX] = true;
                dfs(depth + 1, tmpX, tmpY);

                //再帰から戻ったあとの訪問済みチェックの解除は不要。
                //あるマスへ到着可能であることについて複数のパターンを考慮する必要がないため。
            }
        }
    }
}
