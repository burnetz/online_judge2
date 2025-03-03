package atcoder.abc395;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        //反転の前後をそれぞれ別の層として扱う。
        //これにより普通のダイクストラで解ける。
        ArrayList<Edge>[] edges = new ArrayList[n * 2];
        for(int i = 0; i < n * 2; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            edges[u].add(new Edge(v, 1));
            //反転後のグラフ
            edges[v + n].add(new Edge(u + n, 1));
        }

        //反転そのもののための辺を追加
        for(int i = 0; i < n; i++) {
            edges[i].add(new Edge(i + n, x));
            edges[i + n].add(new Edge(i, x));
        }

        long result[] = dijkstra(edges, 0, n * 2);

        System.out.println(Math.min(result[n - 1], result[2*n - 1]));
    }


    static final Long INF = Long.MAX_VALUE/10;

    //ダイクストラ法
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
    int cost;

    Edge(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}