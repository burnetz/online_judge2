package atcoder.abc396;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        path = new long[n][n];
        visited = new boolean[n];

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long w = sc.nextLong();

            path[u][v] = w;
            path[v][u] = w;
        }

        dfs(0, n, 0);

        System.out.println(result);
    }

    static long path[][];
    static boolean visited[];
    static long result = Long.MAX_VALUE;

    //Nが小さいので全探索で十分間にあう。
    static void dfs(int v, int n, long currentResult) {
        if(v == n - 1) {
            result = Math.min(result, currentResult);
            return;
        }

        visited[v] = true;

        for(int i = 0; i < n; i++) {
            if(!visited[i] && path[v][i] > 0) {
                dfs(i, n, currentResult^path[v][i]);
            }
        }

        visited[v] = false;
    }
}