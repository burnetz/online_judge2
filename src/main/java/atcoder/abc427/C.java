package atcoder.abc427;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        white = new boolean[n];
        edges = new boolean[n][n];

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[u][v] = true;
            edges[v][u] = true;
        }

        dfs(0, n);

        System.out.println(result);

    }

    static boolean[][] edges;
    static boolean[] white;
    static int result = 1000000;

    static void dfs(int currentDepth, int n) {
        if(currentDepth == n) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(edges[i][j] && white[i] == white[j]) {
                        count++;
                    }
                }
            }

            result = Math.min(result, count);

            return;
        }

        white[currentDepth] = false;
        dfs(currentDepth + 1, n);
        white[currentDepth] = true;
        dfs(currentDepth + 1, n);
    }
}