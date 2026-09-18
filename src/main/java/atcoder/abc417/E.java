package atcoder.abc417;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        Vector<Integer>[] edges = new Vector[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            edges[u].add(v);
            edges[v].add(u);
        }

        for(int i = 0; i < n; i++) {
            Collections.sort(edges[i]);
        }

        Vector<Integer> result = new Vector<>();
        result.add(x);

        int current = x;
        Set<Integer> ngList = new HashSet<>();
        Set<Integer> reachableList = new HashSet<>();
        ngList.add(x);
        while(true) {
            for(int i = 0; i < edges[current].size(); i++) {
                int next = edges[current].get(i);
                if(ngList.contains(next)) {
                    continue;
                }
                boolean visit[] = new boolean[n];

                boolean tmp;
                if(reachableList.contains(next)) {
                    tmp = true;
                }
                else {
                    //辞書順を考えずに到達が可能かだけを判定するDFS。
                    //1回あたりO(M)で済む。
                    tmp = dfs(next, y, ngList, visit, reachableList, edges);
                }

                if(tmp) {
                    current = next;
                    break;
                }
            }

            result.add(current);
            ngList.add(current);
            if(current == y) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append((result.get(i) + 1)).append(" ");
        }
        System.out.println(sb);


    }

    static boolean dfs(int current, int goal, Set<Integer> ngList, boolean[] visit, Set<Integer> reachableList, Vector<Integer>[] edges) {
        visit[current] = true;
        if(current == goal) {
            return true;
        }

        for(int i = 0; i < edges[current].size(); i++) {
            int next = edges[current].get(i);

            if(ngList.contains(next) || visit[next]) {
                continue;
            }

            if(reachableList.contains(next)) {
                return true;
            }

            boolean result = dfs(next, goal, ngList, visit, reachableList, edges);

            if(result) {
                //nextからはgoalに到達が可能であることを確認済みという意味。
                //これにより過剰なdfsの実行を回避できるが
                //ngListの更新状況の考慮が不十分にもかかわらず動いている理由が自分にも分からない。
                reachableList.add(next);
                return true;
            }
        }

        return false;
    }
}