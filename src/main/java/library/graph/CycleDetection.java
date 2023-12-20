package library.graph;

import java.util.*;

public class CycleDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Vector<ArrayList<Integer>> edges = new Vector<>();
        seen = new boolean[n];
        finished = new boolean[n];
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            edges.get(a).add(b);
        }

        for(int i = 0; i < n; i++) {
            if(!seen[i]) {
                int result = dfs(edges, i);
                if(result != -1) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean seen[];
    static boolean finished[];

    static Stack<Integer> history = new Stack<>();


    static int dfs(Vector<ArrayList<Integer>> edges, int index) {
        seen[index] = true;
        history.push(index);

        for(int i = 0; i < edges.get(index).size(); i++) {
            int next = edges.get(index).get(i);

            if(finished[next]) {
                continue;
            }

            if(seen[next] && !finished[next]) {
                history.push(next);
                return next;
            }

            int tmp = dfs(edges, next);
            if(tmp != -1) {
                return tmp;
            }
        }

        finished[index] = true;
        history.pop();

        return -1;
    }

    static Vector<Integer> reconstruct(int pos) {
        Vector<Integer> res = new Vector<>();

        // 履歴を遡ってサイクルを形作る
        while (!history.empty()) {
            int v = history.pop();
            res.add(v);
            history.pop();
            if (v == pos) break;
        }

        // サイクルの向きを正順にする
        Collections.reverse(res);
        return res;
    }

}

