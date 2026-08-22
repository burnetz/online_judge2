package atcoder.abc463;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        warpBasicCost = sc.nextInt();

        ArrayList<Edge>[] edges = new ArrayList[n];
        for(int i = 0; i < n ; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m ; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int t = sc.nextInt();
            edges[u].add(new Edge(v, t));
            edges[v].add(new Edge(u, t));
        }

        warpCost = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //素朴に解こうとするとワープにより辺がN^2本増えて密グラフとなりTLE。
        //しかしワープのコストの計算式から、最適なルートであればワープは高々1回であることが分かる。
        //加えて、地点1から見てワープの起点として利用すべき都市も一意に定まるので
        //まずはそのためのダイクストラを行う。
        long resultToPort[] = dijkstra(edges, 0, n);
        int port = 0;
        for(int i = 1; i < n; i++) {
            //道の距離だけでなく、ワープ起点分のコストの和で比較する
            if(resultToPort[i] + warpCost[i] < resultToPort[port] + warpCost[port]) {
                port = i;
            }
        }

        //ワープ装置のための辺の追加。全部でN本だけで済む。
        for(int i = 0 ; i < n; i++) {
            long tmpCost = (long)warpBasicCost + warpCost[port] + warpCost[i];
            edges[port].add(new Edge(i, tmpCost));
            edges[i].add(new Edge(port, tmpCost));
        }

        long result[] = dijkstra(edges, 0, n);

        for(int i = 1; i < n; i++) {
            System.out.print(result[i] + " ");
        }

    }

    static final long INF = 1_000_000_000_000_000_000L;
    static int[] warpCost;
    static int warpBasicCost;

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