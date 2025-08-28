package atcoder.abc372;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //各グループに存在する頂点番号を大きい順に10個まで保存する。
        int matrix[][] = new int[n][10];
        for(int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
            matrix[i][0] = i + 1;
        }

        DisjointSet dj = new DisjointSet(n);

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int u = sc.nextInt() - 1;
                    int v = sc.nextInt() - 1;

                    if(dj.isSameSet(u, v)) {
                        continue;
                    }

                    int pid1 = dj.findSet(u);
                    int pid2 = dj.findSet(v);

                    Integer tmpArray[] = new Integer[20];
                    for(int j = 0; j < 10; j++) {
                        tmpArray[j] = matrix[pid1][j];
                        tmpArray[j + 10] = matrix[pid2][j];
                    }

                    Arrays.sort(tmpArray, (n1, n2) -> Integer.compare(n2, n1));

                    dj.union(u, v);
                    int pid3 = dj.findSet(u);

                    //unionに伴い頂点番号もマージする。
                    //常に最大10個までしか保存されないので間に合う。
                    for(int j = 0; j < 10; j++) {
                        matrix[pid3][j] = tmpArray[j];
                    }
                }
                case 2 -> {
                    int v = sc.nextInt() - 1;
                    int k = sc.nextInt();

                    int pid = dj.findSet(v);

                    System.out.println(matrix[pid][k - 1]);

                }
            }
        }
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
