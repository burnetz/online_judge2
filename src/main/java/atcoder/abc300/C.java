package atcoder.abc300;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int n = Math.min(h, w);
        count = new int[n + 1];

        matrix = new char[h][w];
        visited = new boolean[h][w];

        for(int i = 0; i < h; i++){
            matrix[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(!visited[i][j] && matrix[i][j] == '#'){
                    int tmp = dfs(j, i, h, w);

                    count[(tmp / 4)]++;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.print(count[i] + " ");
        }
    }

    static int[] count;
    static char[][] matrix;
    static boolean[][] visited;

    static final int dx[] = {1, 1, -1, -1};
    static final int dy[] = {-1, 1, 1, -1};
    /*
    頂点を共有するXは無いのでDFSで安全にマスを数えられる。
    #の数が分かればサイズも計算できる。
     */
    static int dfs(int x, int y, int h, int w){
        int result = 1;
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int x2 = x + dx[i];
            int y2 = y + dy[i];

            if(x2 >= 0 && x2 < w && y2 >= 0 && y2 < h && !visited[y2][x2] && matrix[y2][x2] == '#'){
                result += dfs(x2, y2, h, w);
            }
        }

        return result;
    }
}