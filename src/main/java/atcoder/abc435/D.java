package atcoder.abc435;

import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        reachableToBlack = new boolean[n];
        edges = new Vector[n];

        for(int i = 0; i < n; i++) {
            edges[i] = new Vector<>();
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            edges[y].add(x);
        }

        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int v = sc.nextInt() - 1;

            switch (type) {
                case 1 -> {
                    if(!reachableToBlack[v]) {
                        dfs(v);
                    }
                }
                case 2 -> {
                    //到達可能かではなく現に黒いかというイメージ
                    System.out.println(reachableToBlack[v] ? "Yes" : "No");
                }
            }
        }

    }

    static boolean[] reachableToBlack;
    static Vector<Integer>[] edges;

    //わざと矢印を逆に繋いだ上で到達可能な頂点を全て黒塗りする。
    //最初はO(M)かかる可能性があるが黒塗りされるごとに探索範囲が狭くなるので間に合う。
    static void dfs(int index) {
        reachableToBlack[index] = true;

        for(int i = 0; i < edges[index].size(); i++) {
            int tmp = edges[index].elementAt(i);

            if(!reachableToBlack[tmp]) {
                dfs(tmp);
            }
        }
    }
}