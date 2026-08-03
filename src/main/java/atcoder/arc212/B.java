package atcoder.arc212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge>[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        int startX = 0;
        int startY = 0;
        int firstCost = 0;

        //(x,y)に石を置くという行為をxからyへ有効辺を引くと考えれば
        //条件を満たす石の置き方はグラフ内にサイクルを作ることと同じになる。
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int c = sc.nextInt();

            if(i == 0) {
                startX = x;
                startY = y;
                firstCost = c;
            }

            edges[x].add(new Edge(y, c));
        }

        //サイクルの始点と終点に気をつけること。
        long[] result = dijkstra(edges, startY, n);

        if(result[startX] == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(result[startX] + firstCost);
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