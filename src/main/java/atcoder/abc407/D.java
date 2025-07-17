package atcoder.abc407;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        matrix = new long[h][w];
        used = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }

        dfs(0, h, w);

        System.out.println(result);

    }

    static long matrix[][];
    static boolean used[][];
    static long result = 0;

    //サイズが小さいので全探索できる。
    static void dfs(int currentDepth, int maxH, int maxW) {
        if(currentDepth == maxH * maxW) {
            long tmp = 0;

            for(int i = 0; i < maxH; i++) {
                for(int j = 0; j < maxW; j++) {
                    if(!used[i][j]) {
                        tmp ^= matrix[i][j];
                    }
                }
            }

            result = Math.max(result, tmp);
            return;
        }

        int r = currentDepth / maxW;
        int c = currentDepth % maxW;

        if (!used[r][c]) {
            //横置き
            if(c != maxW - 1 && !used[r][c + 1]) {
                used[r][c] = used[r][c + 1] = true;
                dfs(currentDepth + 1, maxH, maxW);
                used[r][c] = used[r][c + 1] = false;
            }

            //縦置き
            if(r != maxH - 1 && !used[r + 1][c]) {
                used[r][c] = used[r + 1][c] = true;
                dfs(currentDepth + 1, maxH, maxW);
                used[r][c] = used[r + 1][c] = false;

            }
        }

        //置かないパターンも忘れないこと
        dfs(currentDepth + 1, maxH, maxW);

    }
}