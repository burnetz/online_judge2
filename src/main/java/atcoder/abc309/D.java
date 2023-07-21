package atcoder.abc309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Edge> edges1[] = new ArrayList[n1];
        ArrayList<Edge> edges2[] = new ArrayList[n2];
        ArrayList<Edge> edges12[] = new ArrayList[n1 + n2];

        for(int i = 0; i < n1; i++){
            edges1[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < n2; i++){
            edges2[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < n1 + n2; i++){
            edges12[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if(b < n1){
                edges1[a].add(new Edge(b, 1));
                edges1[b].add(new Edge(a, 1));
            }
            else if(a >= n1){
                edges2[a - n1].add(new Edge(b - n1, 1));
                edges2[b - n1].add(new Edge(a - n1, 1));
            }

            //グループ1とグループ2をまたぐ辺はここでのみ追加する。
            edges12[a].add(new Edge(b, 1));
            edges12[b].add(new Edge(a, 1));
        }

        int dist1[] = dijkstra(edges1, 0, n1);
        int dist2[] = dijkstra(edges2, n2 - 1, n2);
        int dist12[] = dijkstra(edges12, 0, n1 + n2);

        int result = 0;

        //辺を追加しない場合の最大距離。最終的な答えはこの値を超えない。
        //グループ1と2をつなぐ辺が最初存在しない場合は0のまま。
        for(int i = 0; i < n1 + n2; i++){
            if(dist12[i] != INF){
                result = Math.max(result, dist12[i]);
            }
        }

        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < n1; i++){
            if(dist1[i] != INF){
                max1 = Math.max(max1, dist1[i]);
            }
        }

        for(int i = 0; i < n2; i++){
            if(dist2[i] != INF){
                max2 = Math.max(max2, dist2[i]);
            }
        }
        //グループ間をまたぐ辺を増やした結果最大距離になる場合、
        //その値は"グループ1内の最大距離 + グループ2内の最大距離 + ここで追加する1"
        result = Math.max(max1 + max2 + 1, result);

        System.out.println(result);
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