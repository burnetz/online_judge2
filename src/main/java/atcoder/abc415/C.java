package atcoder.abc415;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc.nextInt(), sc.next());
        }
    }

    //O(N!)で全順序調べるわけにはいかないので各状態を頂点としてダイクストラ法で解く。
    //状態数は多いが辺の数は相対的にかなり少なくなる。
    static void solve(int n, String s) {
        //全部混ぜて危険ならそもそも無理
        if(s.charAt(s.length() - 1) == '1') {
            System.out.println("No");
            return;
        }

        int numOfState = s.length() + 1;

        ArrayList<Edge> edges[] = new ArrayList[numOfState];

        for(int i = 0; i < numOfState; i++){
            if(edges[i] == null){
                edges[i] = new ArrayList<Edge>();
            }
        }

        for(int i = 0; i < numOfState; i++) {
            //危険な状態からは辺が生えない。
            if(i >= 1 && s.charAt(i - 1) == '1') {
                continue;
            }

            int mask = 1;
            for(int j = 0; j < n; j++) {
                if((i & mask) != 1) {
                    int newState = i | mask;
                    edges[i].add(new Edge(newState, 1));
                }

                mask *= 2;
            }
        }

        int[] result = dijkstra(edges, 0, numOfState);

        if(result[numOfState - 1] != INF) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
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