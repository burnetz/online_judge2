package atcoder.abc317;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        route = new int[n][n];
        used = new boolean[n];

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();

            route[a][b] = c;
            route[b][a] = c;
        }

        for(int i = 0; i < n; i++){
            dfs(i, 0, n, 0);
        }

        System.out.println(result);
    }

    static int route[][];
    static boolean used[];

    static long result = -1;

    //頂点数が少ないので全探索で十分間に合う。
    static void dfs (int pos, int depth, int n, long total) {
        if(depth == n) {
            return;
        }

        used[pos] = true;
        for(int i = 0; i < n; i++) {
            if(!used[i] && route[pos][i] > 0) {
                //すべての頂点を網羅する必要はないので随時更新できる。
                result = Math.max(result, total + route[pos][i]);
                dfs(i, depth + 1, n, total + route[pos][i]);
            }
        }
        used[pos] = false;
    }
}
