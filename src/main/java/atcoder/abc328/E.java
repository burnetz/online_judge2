package atcoder.abc328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();

        edgeVector = new Vector<>();
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long cost = sc.nextLong();

            edgeVector.add(new Edge(u, v, cost));
        }
        selectedEdgeId = new int[n - 1];

        visited = new boolean[n];
        solve(0, n - 1, n, -1, k);

        System.out.println(result);
    }

    static Vector<Edge> edgeVector;
    static boolean visited[];
    static long result = Long.MAX_VALUE;
    static int selectedEdgeId[];

    //頂点が8個、あり得る辺の本数が28本、辺の選び方が28 C 7なので全パターンでも間に合う。
    static void solve (int currentDepth, int maxDepth, int n, int prevId, long mod) {

        if(currentDepth == maxDepth) {
            //訪問していない頂点があるなら不適
            for(int i = 0; i < visited.length; i++) {
                if(!visited[i]) {
                    return;
                }
            }

            //もっとDFSの浅い段階でチェックができるかもしれないが
            //ここでDisjoingSetを使って確認しても間に合う。
            DisjointSet dj = new DisjointSet(n);

            long sum = 0;
            for(int i = 0; i < selectedEdgeId.length; i++) {
                Edge tmpEdge = edgeVector.get(selectedEdgeId[i]);
                //ループを持つなら木ではないので不適
                if(dj.isSameSet(tmpEdge.from, tmpEdge.to)) {
                    return;
                }

                dj.union(tmpEdge.from, tmpEdge.to);
                sum += tmpEdge.cost;
                sum %= mod;
            }
            result = Math.min(result, sum%mod);

            return;
        }

        for(int i = prevId + 1; i < edgeVector.size(); i++) {
            Edge tmpEdge = edgeVector.get(i);

            selectedEdgeId[currentDepth] = i;
            //1つの頂点に対して複数の辺が接続し得るので
            //訪問済みというだけではcontinueしない。
            //ただし訪問状況を元に戻すための工夫は必要。
            boolean changeFrom = !visited[tmpEdge.from];
            boolean changeTo = !visited[tmpEdge.to];
            visited[tmpEdge.to] = true;
            visited[tmpEdge.from] = true;
            solve(currentDepth + 1, maxDepth, n, i, mod);
            if(changeFrom) {
                visited[tmpEdge.from] = false;
            }

            if(changeTo) {
                visited[tmpEdge.to] = false;
            }
        }
    }
}

class Edge {
    int to;
    int from;
    long cost;

    Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

    Edge(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
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
