package atcoder.abc333;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n];

        Vector<Integer> edges[] = new Vector[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
        }

        //頂点0自体が葉のときは答えは1
        if(edges[0].size() == 1) {
            System.out.println(1);
            return;
        }

        //頂点0に接続している各点の除去コストを調べる。
        Vector<Long> vec = new Vector<>();
        for(int i = 0; i < edges[0].size(); i++) {
            vec.add(dfs(edges, edges[0].get(i), 0));
        }
        vec.sort(Long::compare);

        //最も除去コストが大きい隣接点を1つ残して全て除去すれば頂点0が葉になる。
        long result = 0;
        for(int i = 0; i < vec.size() - 1; i++) {
            result += vec.get(i);
        }

        System.out.println(result + 1);
    }

    static boolean visited[];

    //除去コストの計算をDFSで行う。
    static long dfs(Vector<Integer>[] edges, int current, int from) {
        visited[current] = true;
        if(edges[current].size() == 1) {
            return 1;
        }

        long result = 0;
        for(int i = 0; i < edges[current].size(); i++) {
            int next = edges[current].get(i);
            if(next != from && !visited[next]) {
                result += dfs(edges, next, current);
            }
        }
        return result + 1;
    }
}
