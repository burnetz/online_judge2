
package atcoder.abc472;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static int[] colors;
    static boolean[] visited;
    static int[] history;
    static int goalDepth;

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        colors = new int[n];
        history = new int[n];
        visited = new boolean[n];
        Arrays.fill(history, -1);

        Vector<Integer>[] edges = new Vector[n];
        Vector<Integer>[] treeEdges = new Vector[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
            treeEdges[i] = new Vector<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
        }

        //全域木を構築しつつ、各頂点に色（0,1）を同じ色が隣り合わないように割り当てる。
        setColor(edges, treeEdges,0, 0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < edges[i].size(); j++) {
                int v = edges[i].get(j);
                //全域木の中の同じ色の頂点どうしを結べば頂点数奇数のサイクルになる。
                if(colors[i] == colors[v]) {
                    visited = new boolean[n];
                    constructRoute(treeEdges, i, 0, v);

                    System.out.println(goalDepth + 1);
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k <= goalDepth; k++) {
                        sb.append((history[k] + 1) + " ");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }

        System.out.println("-1");
    }

    static void setColor(Vector<Integer>[] edges, Vector<Integer>[] treeEdges, int target, int color) {
        colors[target] = color;
        visited[target] = true;

        for(int i = 0; i < edges[target].size(); i++) {
            int next = edges[target].get(i);
            int nextColor = color == 0 ? 1 : 0;

            if(!visited[next]) {
                treeEdges[target].add(next);
                treeEdges[next].add(target);
                setColor(edges, treeEdges, next, nextColor);
            }
        }
    }

    //もともとのグラフではなく全域木を引数に渡すこと。
    static boolean constructRoute(Vector<Integer>[] edges, int target, int currentDepth, int goal) {
        visited[target] = true;
        history[currentDepth] = target;
        if(target == goal) {
            goalDepth = currentDepth;
            return true;
        }

        boolean reached;
        for(int i = 0; i < edges[target].size(); i++) {
            int v = edges[target].get(i);

            if(!visited[v]) {
                if(colors[target] == colors[v]) {
                    System.exit(1);
                }
                reached = constructRoute(edges, v, currentDepth + 1, goal);

                if(reached) {
                    return true;
                }
            }
        }
        return false;
    }

}