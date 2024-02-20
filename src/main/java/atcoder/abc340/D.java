package atcoder.abc340;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge> edges[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            if(edges[i] == null){
                edges[i] = new ArrayList<Edge>();
            }
        }

        for(int i = 0; i < n - 1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt() - 1;

            if(x == i + 1) {
                edges[i].add(new Edge(x, Math.min(a, b)));
            }
            else {
                edges[i].add(new Edge(i + 1, a));
                edges[i].add(new Edge(x, b));
            }
        }

        long result[] = dijkstra(edges, 0, n );

        System.out.println(result[n - 1]);
    }

    static final long INF = 1_000_000_000_000_000L;

    //ダイクストラ法で問題なく解くことができる。
    //オーバーフローには注意する。
    static long[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

        PriorityQueue<Distance> que = new PriorityQueue<Distance>();
        long[] dist = new long[n];

        Arrays.fill(dist, INF);
        dist[s] = 0;
        que.add(new Distance(0, s));

        while(!que.isEmpty()){
            Distance tmpDist = que.poll();
            int tmpV = tmpDist.id;

            if(dist[tmpV] < tmpDist.dist){
                continue;
            }
            for(int i = 0; i < edges[tmpV].size() ; i++){
                Edge e = (Edge) edges[tmpV].get(i);
                if(dist[e.to] > dist[tmpV] + e.cost){
                    dist[e.to] = dist[tmpV] + e.cost;
                    que.add(new Distance(dist[e.to], e.to));
                }
            }
        }

        return dist;
    }
}

class Distance implements Comparable<Distance>{
    long dist;
    int id;

    Distance(long dist, int id){
        this.dist = dist;
        this.id = id;
    }

    @Override
    public int compareTo(Distance d) {
        return Long.compare(this.dist, d.dist);
    }
}

class Edge {
    int to;
    long cost;

    Edge(int to, long cost){
        this.to = to;
        this.cost = cost;
    }
}