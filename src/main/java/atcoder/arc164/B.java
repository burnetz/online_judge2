package atcoder.arc164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //2点間を交互の色で繋ぐことができるなら同じグループとみなす。
        DisjointSet dj = new DisjointSet(n);

        ArrayList<Integer>[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            edges[a].add(b);
            edges[b].add(a);
        }

        int color[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < edges[i].size(); j++) {
                int to = edges[i].get(j);

                if(color[i] != color[to]) {
                    dj.union(i, to);
                }
            }
        }

        //2重ループだが合計で辺の数しか回らないので間に合う。
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < edges[i].size(); j++) {
                int to = edges[i].get(j);

                //元の場所に戻るためにはスタート地点とラスト一手前がもともと同じ色でなければならない。
                //なおかつ途中の移動は色が交互でなければならない。
                if(color[i] == color[to] && dj.isSameSet(i, to)) {
                    System.out.printf("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
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
