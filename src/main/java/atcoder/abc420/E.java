package atcoder.abc420;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        DisjointSet dj = new DisjointSet(n);
        //どのグループにも代表IDが存在するので、代表に対してのみ黒い点の個数を保存する。
        int count[] = new int[n];
        //各頂点の色は個別に管理する
        boolean isBlack[] = new boolean[n];

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

                    //union時には黒い頂点の個数も総和に更新する。
                    int sum = count[pid1] + count[pid2];

                    dj.union(u, v);

                    //union後の代表IDは不明なので再取得する。
                    int pid3 = dj.findSet(u);

                    count[pid3] = sum;

                }
                case 2 -> {
                    int v = sc.nextInt() - 1;
                    int pid = dj.findSet(v);

                    if(isBlack[v]) {
                        isBlack[v] = false;
                        count[pid]--;
                    }
                    else {
                        isBlack[v] = true;
                        count[pid]++;
                    }
                }
                case 3 -> {
                    int v = sc.nextInt() - 1;
                    int pid = dj.findSet(v);

                    if(count[pid] > 0) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }

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
