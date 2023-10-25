package atcoder.abc325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //前半は自家用車だけで行けるところ。後半は電車での移動を開始後に行けるところ。
        ArrayList<Edge>[] edges = new ArrayList[2*n];
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            //一度電車を使うと車を使えないので一方通行
            edges[i].add(new Edge(i + n, 0));
            for(int j = 0; j < n; j++) {
                long d = sc.nextLong();
                long car = a * d;
                long train = d * b + c;

                edges[i].add(new Edge(j, car));
                edges[i + n].add(new Edge(j + n, train));
            }
        }

        long result[] = dijkstra(edges, 0, 2*n);

        //電車を全く使わないパターンと電車を1回以上使うパターンのうち小さい方が答え
        System.out.println(Math.min(result[n - 1], result[2*n - 1]));

    }

    static final long INF = 1_000_000_000_000_000_000L;

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
    long cost;

    Edge(int to, long cost){
        this.to = to;
        this.cost = cost;
    }
}