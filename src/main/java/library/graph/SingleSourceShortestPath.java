package library.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleSourceShortestPath {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmpArray = br.readLine().split(" ");

        //0 origin
        int n = Integer.parseInt(tmpArray[0]);
        int m = Integer.parseInt(tmpArray[1]);
        int x = Integer.parseInt(tmpArray[2]);

        @SuppressWarnings("unchecked")
        ArrayList<Edge> edges[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            if(edges[i] == null){
                edges[i] = new ArrayList<Edge>();
            }
        }

        for(int i = 0; i < m; i++){
            tmpArray = br.readLine().split(" ");
            int from = Integer.parseInt(tmpArray[0]);
            int to = Integer.parseInt(tmpArray[1]);
            int cost = Integer.parseInt(tmpArray[2]);

            edges[from].add( new Edge(to, cost));
        }

        solve(edges, n, x);
    }


    static void solve(ArrayList<Edge>[] edges,  int n, int x){
        int[] dist = dijkstra(edges, x, n);

        for(int i = 0; i < n; i++){
            if(dist[i] == INF){
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }

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