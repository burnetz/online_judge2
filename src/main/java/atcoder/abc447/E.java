package atcoder.abc447;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Pair[] pairs = new Pair[m];

        for(int i = 0; i < m ; i++) {
            pairs[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        DisjointSet dj = new DisjointSet(n);

        boolean[] used = new boolean[m];
        //辺のコストc[i]がすべて2のべき乗なので、c[0]からc[i - 1]の和よりもc[i]の方が常に大きい。
        //そのため、コストが重い順にどうしても使わなければならない辺を決めていけばよい。
        for(int i = m - 1; i >= 0; i--) {
            int u = pairs[i].u();
            int v = pairs[i].v();
            //その辺を追加することで連結成分の個数が1になるもの以外は必要な辺。
            if(dj.numOfGroup() >= 3 || (dj.numOfGroup() == 2 && dj.isSameSet(u, v))) {
                dj.union(u, v);
                used[i] = true;
            }
        }

        long result = 0;
        int mod = 998244353;
        for(int i = 0; i < m; i++) {
            if(!used[i]) {
                result += repeatablePow(2, i + 1, mod);
                result %= mod;
            }
        }

        System.out.println(result);

    }

    static long repeatablePow(int x, long n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }
}

record Pair(int u, int v) {}

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
