package atcoder.abc304;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        //もし2グループしかないなら2N個の要素を持ったDisjointSetで対応できたが
        //敵の敵が味方とは限らないので今回は「道で繋がっているか」のみの管理に使う。
        DisjointSet2 dj = new DisjointSet2(n);

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            dj.union(a, b);
        }

        //グループごとのIDを管理する。findeSet()メソッドで取得可能
        int[] groupId = new int[n];

        for(int i = 0; i < n; i++) {
            groupId[i] = dj.findSet(i);
        }

        //グループごとに「繋げてはいけないグループ」を保存する。
        HashSet<Integer>[] enemyList = new HashSet[n];
        for(int i = 0; i < n; i++) {
            enemyList[i] = new HashSet<Integer>();
        }

        int k = sc.nextInt();

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            enemyList[groupId[a]].add(groupId[b]);
            enemyList[groupId[b]].add(groupId[a]);
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(enemyList[groupId[a]].contains(groupId[b]) ? "No" : "Yes");
        }

    }
}

class DisjointSet2 {
    private int n;
    private int[] p;
    private int[] rank;
    //各グループの要素数を管理する
    private int[] num;
    //グループ数を管理する
    private int numOfGroup;

    public DisjointSet2(int n){
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
