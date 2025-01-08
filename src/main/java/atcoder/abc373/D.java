package atcoder.abc373;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long nodeWeight[] = new long[n];
        Arrays.fill(nodeWeight, Long.MIN_VALUE);

        ArrayList<Edge>[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            long cost = sc.nextLong();

            edges[from].add(new Edge(to, cost));
            //逆向き、コスト-1倍の辺を考えることで
            //どこから始めても網羅できるようになる。
            edges[to].add(new Edge(from, -cost));
        }

        //条件を満たす数列自体はスタート地点を0としてBFSで求められる。
        //（試していないがDFSでも可？）
        //ただし島が複数ある可能性があるので注意。
        for(int i = 0; i < n; i++) {
            if(nodeWeight[i] != Long.MIN_VALUE) {
                continue;
            }

            Deque<Integer> que = new ArrayDeque<>();
            nodeWeight[i] = 0;
            que.add(i);

            while(!que.isEmpty()) {
                int tmpIndex = que.removeFirst();

                for(int j = 0; j < edges[tmpIndex].size(); j++) {
                    Edge tmpEdge = edges[tmpIndex].get(j);
                    if(nodeWeight[tmpEdge.to] == Long.MIN_VALUE) {
                        nodeWeight[tmpEdge.to] = nodeWeight[tmpIndex] + tmpEdge.cost;
                        que.add(tmpEdge.to);
                    }
                }
            }


        }

        Arrays.stream(nodeWeight).forEach(e -> System.out.print(e + " "));

    }
}

class Edge {
    int to;
    long cost;

    Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

}