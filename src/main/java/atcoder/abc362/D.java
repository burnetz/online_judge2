package atcoder.abc362;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int num = 2*n;

        //各頂点のINとOUTを別の頂点として扱うことで解ける。
        ArrayList<Edge> edges[] = new ArrayList[num];

        for(int i = 0; i < num; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            int from = i;
            int to = i + n;
            int cost = sc.nextInt();

            edges[from].add( new Edge(to, cost));
        }

        for(int i = 0; i < m; i++){
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();

            edges[from + n].add( new Edge(to, cost));
            edges[to + n].add( new Edge(from, cost));
        }

        long result[] = dijkstra(edges, 0, 2*n);

        for(int i = 1; i < n; i++) {
            System.out.print(result[i + n] + " ");
        }
    }

    static final long INF = 1_000_000_000_000_000L;

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