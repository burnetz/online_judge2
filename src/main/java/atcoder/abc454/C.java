package atcoder.abc454;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Edge> edges[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            if(edges[i] == null){
                edges[i] = new ArrayList<Edge>();
            }
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(new Edge(b, 1));
        }

        int dist[] = dijkstra(edges, 0, n);

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(dist[i] != INF) {
                count++;
            }
        }

        System.out.println(count);
    }

    static final int INF = Integer.MAX_VALUE;

    //ダイクストラ法
    static int[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

        PriorityQueue<Distance> que = new PriorityQueue<Distance>();
        int[] dist = new int[n];

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
    int dist;
    int id;

    Distance(int dist, int id){
        this.dist = dist;
        this.id = id;
    }

    @Override
    public int compareTo(Distance d) {
        return this.dist - d.dist;
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
