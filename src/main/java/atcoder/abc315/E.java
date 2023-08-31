package atcoder.abc315;

import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //各頂点に入る辺の本数を記録する
        int inNum[] = new int[n];

        visited = new boolean[n];
        toBook0 = new boolean[n];

        //入力をグラフとみなす
        lists = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        //トポロジカルソートのための準備
        for(int i = 0; i < n; i++) {
            int c = sc.nextInt();
            for(int j = 0; j < c; j++) {
                int a = sc.nextInt() - 1;

                inNum[i]++;
                lists[a].add(i);

            }
        }

        //普通にトポロジカルソートをすると本1と関係のない頂点まで含まれてしまうため
        //事前に本1との繋がりを確認しておく。
        for(int i = 1; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        //ここからトポロジカルソート
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Vector<Integer> result = new Vector<Integer>();

        for(int i = 0; i < n; i++) {
            if(inNum[i] == 0) {
                pq.add(i);
            }
        }
        while(!pq.isEmpty()) {
            int v = pq.remove();

            result.add(v);
            for(int i = 0; i < lists[v].size(); i++) {
                int to = lists[v].get(i);

                inNum[to]--;

                if(inNum[to] == 0) {
                    pq.add(to);
                }
            }
        }

        //ここまでトポロジカルソート

        for(int i = 0; i < result.size(); i++) {
            int tmp = result.get(i);
            if(tmp == 0) {
                break;
            }
            //本1と関係のある頂点だけを出力する。
            if(toBook0[tmp]){
                System.out.print(tmp + 1 + " ");
            }
        }
        System.out.println();
    }

    static boolean visited[];
    static boolean toBook0[];
    static ArrayList<Integer>[] lists;

    static boolean dfs(int index) {
        visited[index] = true;
        for(int i = 0; i < lists[index].size(); i++) {
            int next = lists[index].get(i);
            if(next == 0) {
                toBook0[index] = true;
                break;
            }

            else if(visited[next]) {
                toBook0[index] = toBook0[index] || toBook0[next];
            }

            else if(dfs(next)) {
                toBook0[index] = true;
                break;
            }
        }

        return toBook0[index];
    }

}