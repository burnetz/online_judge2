package atcoder.arc224;

import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vector<Integer>[] vectors = new Vector[n];
        for(int i = 0; i < n; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            vectors[u].add(v);
            vectors[v].add(u);
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int[] depth = new int[n];
        depth[0] = 0;
        dfs(vectors, visited, depth, 0, 0, n);

        StringBuffer sb = new StringBuffer();
        //String型のまま結合するとTLEになる。
        for(int i = 0; i < n; i++) {
            sb.append(depth[i]);
            sb.append(" ");
        }
        System.out.println(sb);


    }

    //DFSで木を構築して深さを記録すれば自ずと条件を満たす数列になる。BFSはおそらく不可。
    static void dfs(Vector<Integer>[] edges, boolean[] visited, int[] depth, int target, int currentDepth, int n) {
        if(currentDepth == n) {
            return;
        }

        visited[target] = true;
        depth[target] = currentDepth;

        for(int i = 0; i < edges[target].size(); i++) {
            int next = edges[target].get(i);

            if(!visited[next]) {
                dfs(edges, visited, depth, next, currentDepth + 1, n);
            }
        }
    }
}