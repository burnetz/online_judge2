package atcoder.abc327;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[m]).map(e -> sc.nextInt() - 1).toArray();
        int b[] = Arrays.stream(new int[m]).map(e -> sc.nextInt() - 1).toArray();

        //0〜n-1までは「あるインデックスに対応する数字が0である」 n〜2*n - 1は「あるインデックスに対応する数字が1である」
        DisjointSet dj = new DisjointSet(2*n);
        for(int i = 0; i < m; i++) {
            //ともに0またはともに1が確定している場合は矛盾
            if(dj.isSameSet(a[i], b[i]) || dj.isSameSet(a[i] + n, b[i] + n)) {
                System.out.println("No");
                return;
            }

            //a[i]が0でb[i]が1
            dj.union(a[i], b[i] + n);
            //a[i]が1でb[i]が0
            dj.union(a[i] + n, b[i]);
        }

        System.out.println("Yes");
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
