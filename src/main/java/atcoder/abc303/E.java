package atcoder.abc303;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> edges[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        int degree[] = new int[n];
        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        PriorityQueue<Integer> result = new PriorityQueue<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int distance[] = new int[n];
        boolean visited[] = new boolean[n];

        //次数1の頂点をスタートにする。
        int start = -1;
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                start = i;
                break;
            }
        }

        //星の直径はすべて3かつ端の頂点どうししか結ばれないので
        //スタートから見た距離を3で割った余りが1の箇所が星の中心。
        //ルール上星のレベルが変わることはない。
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int u = que.remove();
            for(int i = 0; i < edges[u].size(); i++) {
                int v = edges[u].get(i);
                if(visited[v]){
                    continue;
                }

                distance[v] = distance[u] + 1;
                visited[v] = true;
                que.add(v);
            }
        }

        for(int i = 0; i < n; i++) {
            if(distance[i] % 3 == 1) {
                result.add(degree[i]);
            }
        }

        while(!result.isEmpty()) {
            System.out.print(result.remove() + " ");
        }
    }
}
