package atcoder.abc368;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        for(int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
        }

        int start = 0;
        for(int i = 0; i < k; i++) {
            int v = sc.nextInt() - 1;
            start = v;
            coreNodes.add(v);
        }

        dfs(start);

        System.out.println(n - removable);
    }

    static Set<Integer> coreNodes = new HashSet<>();
    static ArrayList<Integer>[] edges;
    static int removable = 0;
    static boolean visited[];

    //木構造なので自分より先に必須ノードが無い場合そのノードも不要、
    //先のどこかに必須ノードがあればそのノードも必要ということになる。
    //ただし必須ノードから始めること。
    //この方法で削除可能なノード数を求める。
    static boolean dfs(int index) {
        boolean result = false;
        visited[index] = true;

        if(coreNodes.contains(index)) {
            result = true;
        }

        for(int i = 0; i < edges[index].size(); i++) {
            int next = edges[index].get(i);

            if(!visited[next]) {
                result |= dfs(next);
            }

        }

        if(!result) {
            removable++;
        }

        return result;
    }
}

