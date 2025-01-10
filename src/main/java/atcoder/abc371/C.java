package atcoder.abc371;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        digits = new int[n];
        used = new boolean[n];

        matrix1 = new int[n][n];
        matrix2 = new int[n][n];
        costs = new long[n][n];

        int m1 = sc.nextInt();
        for(int i = 0; i < m1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            matrix1[a][b] = 1;
            matrix1[b][a] = 1;
        }

        int m2 = sc.nextInt();
        for(int i = 0; i < m2; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            matrix2[a][b] = 1;
            matrix2[b][a] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                costs[i][j] = costs[j][i] = sc.nextInt();
            }
        }

        dfs(0, n);

        System.out.println(result);
    }

    static int digits[];
    static boolean used[];
    static long result = Long.MAX_VALUE;
    static int matrix1[][];
    static int matrix2[][];
    static long costs[][];

    //頂点の対応付けの方法が40320通り、辺が最大28本なので全パターン試せる。
    static void dfs(int currentDepth, int maxDepth) {
        if(currentDepth == maxDepth) {
            long tmpResult = 0;
            //グラフ1とグラフ2で異なる箇所があればコスト加算
            for(int i = 0; i < maxDepth; i++) {
                for(int j = i + 1; j < maxDepth; j++) {
                    if(matrix1[i][j] != matrix2[digits[i]][digits[j]]) {
                        tmpResult += costs[digits[i]][digits[j]];
                    }
                }
            }

            result = Math.min(tmpResult, result);
            return;
        }

        for(int i = 0; i < maxDepth; i++) {
            if(!used[i]) {
                used[i] = true;
                digits[currentDepth] = i;
                dfs(currentDepth + 1, maxDepth);
                used[i] = false;
            }
        }
    }
}