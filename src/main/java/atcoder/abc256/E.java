package atcoder.abc256;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();
        int c[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        DisjointSet dj = new DisjointSet(n);

        long total = 0;
        //グラフは1つ以上の連結成分からなる。
        //まず異なる連結成分どうしは答えに影響しないので個別に計算すればOK。
        //全ての点の出次数が1なので1つの連結成分は必ず1つのサイクルを含む。1つだけなのでDisjoint Setで検出できる。
        //サイクル以外の辺はコストを0にできる。サイクル内の辺のうち1本だけがコストとなる。
        for (int i = 0; i < n; i++) {
            if(!dj.isSameSet(i, x[i])) {
                dj.union(i, x[i]);
                continue;
            }

            //以下はサイクルが検出されたときの処理。
            int tmpMin = c[i];
            for(int u = x[i]; u != i ; u = x[u]) {
                tmpMin = Math.min(tmpMin, c[u]);
            }
            total += tmpMin;

        }
        System.out.println(total);

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
