package atcoder.abc351;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        DisjointSet dj = new DisjointSet(h*w);

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        boolean[][] magnetNeighbor = new boolean[h][w];
        //まずは磁石の近隣であるマスに印をつける
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '.') {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == '.') {
                        magnetNeighbor[tmpY][tmpX] = true;
                    }
                }
            }
        }

        //相互に行き来可能なマスは同じグループとする。
        //（あくまで相互。磁石の近隣は互いに行き来できない複数のグループに属しうるのでここでは排除）
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#' || magnetNeighbor[i][j]) {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == '.' && !magnetNeighbor[tmpY][tmpX]) {
                        dj.union(i * w + j, tmpY * w + tmpX);
                    }
                }
            }
        }

        HashSet<Integer>[] sets = new HashSet[h*w];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet();
        }

        //各グループの島に接している「磁石の近隣」マスは
        //それぞれのグループがsetで個数管理をする。
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(!magnetNeighbor[i][j]) {
                    continue;
                }
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == '.' && !magnetNeighbor[tmpY][tmpX]) {
                        int groupId = dj.findSet(tmpY * w + tmpX);
                        sets[groupId].add(i*w + j);
                    }
                }
            }
        }

        int result = 1;
        //「島の普通のマス」+「島に接する磁石近隣マス」の合計の最大値が答え。
        for(int i = 0; i < h*w; i++) {
            if(matrix[i/w][i%w] == '#' || magnetNeighbor[i/w][i%w]) {
                continue;
            }
            if(dj.findSet(i) == i) {
                result = Math.max(result, dj.amountOfOwnGroup(dj.findSet(i)) + sets[dj.findSet(i)].size());
            }
        }

        System.out.println(result);
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
