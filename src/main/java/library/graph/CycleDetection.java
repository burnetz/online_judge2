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
                boolean result = dfs(edges, i);
                if(result) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean seen[];
    static boolean finished[];


    static boolean dfs(Vector<ArrayList<Integer>> edges, int index) {
        seen[index] = true;

        for(int i = 0; i < edges.get(index).size(); i++) {
            int next = edges.get(index).get(i);

            if(finished[next]) {
                continue;
            }

            if(seen[next] && !finished[next]) {
                return true;
            }

            if(dfs(edges, next)) {
                return true;
            }
        }

        finished[index] = true;

        return false;
    }

}

