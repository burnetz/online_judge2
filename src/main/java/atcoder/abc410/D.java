package atcoder.abc410;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(new Edge(b, sc.nextInt()));
        }

        sets = new Set[n];
        for(int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }

        dfs(0, 0);

        //最終的な答えも（あるなら）0~1023のどれか
        for(int i = 0; i < 1024; i++) {
            if(sets[n - 1].contains(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }

    static ArrayList<Edge> edges[];
    static Set<Integer>[] sets;

    //同じルートを周回する可能性もあるので一見するとルート総当りはパターン数が多く見えるが
    //頂点ごとに取りうるコストが1024通りしかないのでメモして重複を回避すれば間に合う。
    static void dfs(int v, int currentValue) {
        if(sets[v].contains(currentValue)) {
            return;
        }

        sets[v].add(currentValue);

        for(int i = 0; i < edges[v].size(); i++) {
            Edge tmpEdge = edges[v].get(i);

            int nextValue = currentValue ^ tmpEdge.cost;

            dfs(tmpEdge.to, nextValue);
        }
    }
}

class Edge {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}