package atcoder.abc450;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt() + 2;
        int w = sc.nextInt() + 2;

        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(matrix[i], '.');
        }

        for(int i = 1; i < h - 1; i++) {
            String s = sc.next();
            for(int j = 1; j < w - 1; j++) {
                matrix[i][j] = s.charAt(j - 1);
            }
        }

        DisjointSet dj = new DisjointSet(h * w);

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                switch (matrix[i][j]) {
                    case '#' -> {
                        dj.union(index(0, 0, w), index(i, j , w));
                    }
                    case '.' -> {
                        for(int k = 0; k < 4; k++) {
                            int tmpX = j + dx[k];
                            int tmpY = i + dy[k];

                            if(inRange(tmpY, tmpX, h, w) && matrix[tmpY][tmpX] == '.') {
                                dj.union(index(i, j, w), index(tmpY, tmpX, w));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dj.numOfGroup() - 1);


    }

    static int index (int r, int c, int w) {
        return r * w + c;
    }

    static boolean inRange(int r, int c, int h, int w) {
        return r >= 0 && r < h && c >= 0 && c < w;
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
