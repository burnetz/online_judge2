package atcoder.abc264;

import java.util.Scanner;
import java.util.Arrays;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];
        for(int i = 0; i < e; i++) {
            edges[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        int q = sc.nextInt();
        int events[] = new int[q];
        boolean available[] = new boolean[e];
        Arrays.fill(available, true);
        for(int i = 0; i < q; i++) {
            events[i] = sc.nextInt() - 1;
            available[events[i]] = false;
        }

        DisjointSet dj = new DisjointSet(n + m);
        //発電所どうしは全て同じグループ扱いにしても結果は変わらない。
        for(int i = n + 1; i < n + m; i++) {
            dj.union(i - 1, i);
        }

        //全てのイベント後に残っている辺だけをつなぐ
        for(int i = 0; i < e; i++) {
            if(available[i]) {
                int u = edges[i].from;
                int v = edges[i].to;

                dj.union(u, v);
            }
        }

        int[] result = new int[q];
        //逆順にシミュレーションすればやることが切断ではなく結合なので
        //DisjointSetを使って容易に求められる。
        for(int i = q - 1; i >= 0; i--) {
            //発電所1と同じグループの要素数から発電所数を引けば都市数になる。
            result[i] = dj.amountOfOwnGroup(n) - m;

            Edge tmpEdge = edges[events[i]];
            dj.union(tmpEdge.from, tmpEdge.to);
        }

        Arrays.stream(result).forEach(System.out::println);
    }

}

class Edge {
    int from;
    int to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

class DisjointSet {
    private int n;
    private int[] p;
    private int[] rank;
    //各グループの要素数を管理する
    private int[] num;
    //グループ数を管理する
    private int numOfGroup;

    public DisjointSet(int n){
        this.n = n;

        p = new int[n + 1];
        rank = new int[n + 1];

        num = new int[n + 1];

        Arrays.fill(num, 1);

        for(int i = 1; i <= n; i++){
            makeSet(i);
        }

        numOfGroup = n;
    }

    private void makeSet(int x){
        p[x] = x;
        rank[x] = 0;
    }

    public void union(int x, int y){
        int p1 = findSet(x), p2 = findSet(y);
        int num1 = num[p1];
        int num2 = num[p2];
        link (findSet(x), findSet(y));

        if(p1 != p2) {
            num[p1] = num[p2] = num1 + num2;
            numOfGroup--;
        }
    }

    public int amountOfOwnGroup(int x) {
        return num[findSet(x)];
    }

    public int numOfGroup() {
        return numOfGroup;
    }
    private int findSet(int x){
        if(x != p[x]){
            p[x] = findSet( p[x]);
        }
        return p[x];
    }

    public boolean isSameSet(int x, int y){
        return findSet(x) == findSet(y);
    }

    private void link(int x, int y){
        if(rank[x] > rank[y]){
            p[y] = x;
        }
        else {
            p[x] = y;
            if(rank[x] == rank[y]){
                rank[y]++;
            }
        }
    }

    //for debug
    public void printPArray() {
        for(int i = 1; i <= n; i++) {
            System.out.print(p[i]+" ");
        }
        System.out.println();
    }
}
