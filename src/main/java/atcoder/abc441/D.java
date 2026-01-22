package atcoder.abc441;

import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        long s = sc.nextInt();
        long t = sc.nextInt();

        edges = new Vector[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        isOk = new boolean[n];

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long c = sc.nextLong();

            edges[u].add(new Edge(v, c));
        }

        dfs(0, 0, l, 0, s, t);

        for(int i = 0; i < n; i++) {
            if(isOk[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    static Vector<Edge>[] edges;
    static boolean[] isOk;

    //DFSをするにあたって特に工夫する点は無いが、制約上4^10=2^20程度しか実行されないため間に合う。
    static void dfs(int v, int currentDepth, int maxDepth, long currentCost, long minCost, long maxCost) {
        if(currentDepth == maxDepth) {
            if(currentCost >= minCost && currentCost <= maxCost) {
                isOk[v] = true;
            }

            return;
        }

        for(int i = 0; i < edges[v].size(); i++) {
            Edge tmpEdge = edges[v].elementAt(i);
            int tmpNext = tmpEdge.to;
            long tmpCost = tmpEdge.cost;

            dfs(tmpNext, currentDepth + 1, maxDepth, currentCost + tmpCost, minCost, maxCost);
        }
    }
}

class Edge {
    int to;
    long cost;

    public Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }
}