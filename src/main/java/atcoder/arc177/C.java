package atcoder.arc177;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] matrix = new char[n][n];

        for(int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        ArrayList<Edge> edges[] = new ArrayList[n * n];
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        //紫にすることで赤と青の双方にとってプラスになるマスは存在しない。
        //（片一方にとっては変化しなくても元々通れる）
        //そのため赤と青のそれぞれの立場から個別にダイクストラで解けば良い。

        //まずは赤の立場で解く。
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= n ){
                        continue;
                    }
                    int index1 = i*n + j;
                    int index2 = tmpY*n + tmpX;
                    int cost;
                    //赤->赤はもちろん、青->赤のときも追加のコストは不要
                    if(matrix[tmpY][tmpX] == 'R') {
                        cost = 0;
                    }
                    //今いるマスに関わらず青に行くときは追加のコストが必要
                    else {
                        cost = 1;
                    }
                    edges[index1].add(new Edge(index2, cost));
                }
            }
        }

        int[] dist = dijkstra(edges, 0, n*n);
        int result = dist[n*n - 1];

        //青の立場だとコストが変わるので計算をし直す。
        Arrays.stream(edges).forEach(e -> e.clear());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= n ){
                        continue;
                    }
                    int index1 = i*n + j;
                    int index2 = tmpY*n + tmpX;
                    int cost;
                    if(matrix[tmpY][tmpX] == 'B') {
                        cost = 0;
                    }
                    else {
                        cost = 1;
                    }
                    edges[index1].add(new Edge(index2, cost));
                }
            }
        }
        dist = dijkstra(edges, n*(n - 1), n*n);
        result += dist[n - 1];

        System.out.println(result);
    }

    static final int INF = 1_000_000_000;

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