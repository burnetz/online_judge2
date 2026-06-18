package atcoder.abc424;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n + 1];

        Vector<Integer>[] edges = new Vector[n + 1];
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            edges[a].add(i);
            edges[b].add(i);
        }

        dfs(edges, 0);

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                count++;
            }
        }

        System.out.println(count);


    }

    static boolean visited[];

    static void dfs(Vector<Integer>[] edges, int v) {
        visited[v] = true;

        for(int i = 0; i < edges[v].size(); i++) {
            int next = edges[v].get(i);

            if(!visited[next]) {
                dfs(edges, next);
            }
        }
    }
}

