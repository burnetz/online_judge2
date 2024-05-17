package atcoder.abc352;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Query[] queries = new Query[m];
        for(int i = 0; i < m; i++) {
            int k = sc.nextInt();
            int c = sc.nextInt();
            int[] array = Arrays.stream(new int[k]).map(e -> sc.nextInt() - 1).toArray();

            queries[i] = new Query(c, array);
        }
        Arrays.sort(queries);

        long result = 0;
        DisjointSet dj = new DisjointSet(n);

        //クラスカル法の要領で辺の重みが小さい順に処理をする。
        //その際、既に同じ木に属している頂点に対しては処理をしない。
        //辺が全部で400000本以下なのでこの方法で間にあう。
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < queries[i].array.length; j++) {
                int from = queries[i].array[0];
                int to = queries[i].array[j];

                if(!dj.isSameSet(from, to)) {
                    dj.union(from, to);
                    result += queries[i].weight;
                }
            }
        }

        //木になっていない可能性があるので確認する。
        if(dj.amountOfOwnGroup(dj.findSet(0)) != n) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }
}

class Query implements Comparable<Query>{
    long weight;
    int[] array;

    Query(long weight, int[] array) {
        this.weight = weight;
        this.array = array;
    }

    @Override
    public int compareTo(Query q) {
        return Long.compare(this.weight, q.weight);
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
    public int findSet(int x){
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
