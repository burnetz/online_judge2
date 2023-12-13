package atcoder.arc107;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int matrix[][] = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        DisjointSet djRow = new DisjointSet(n);
        DisjointSet djCol = new DisjointSet(n);
        int mod = 998244353;

        //例えばA行とB行が入れ替え可能でA行とC行が入れ替え可能なら
        //推移律によりA行とC行も入れ替え可能。
        //そのため相互に入れ替え可能なもの同士をDisjointSetでグループ分けできる。
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                boolean ok = true;
                for(int l = 0; l < n; l++) {
                    if(matrix[i][l] + matrix[j][l] > k) {
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    djRow.union(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                boolean ok = true;
                for(int l = 0; l < n; l++) {
                    if(matrix[l][i] + matrix[l][j] > k) {
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    djCol.union(i, j);
                }
            }
        }

        long resultRow = 1;
        for(int i = 0; i < n; i++) {
            if(i == djRow.findSet(i)) {
                resultRow *= fact(djRow.amountOfOwnGroup(i), mod);
                resultRow %= mod;
            }
        }

        long resultCol = 1;
        for(int i = 0; i < n; i++) {
            if(i == djCol.findSet(i)) {
                resultCol *= fact(djCol.amountOfOwnGroup(i), mod);
                resultCol %= mod;
            }
        }

        System.out.println(resultCol*resultRow%mod);
    }

    static long fact(int n, int mod) {
        long result = 1;
        for(int i = 1; i <= n; i++) {
            result = result * i % mod;
        }

        return result;
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
