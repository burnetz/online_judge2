package atcoder.abc310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DisjointSet dj = new DisjointSet(n);

        String str[] = new String[n];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            String reverse = new StringBuffer(str[i]).reverse().toString();

            String smallerStr = str[i].compareTo(reverse) <= 0 ? str[i] : reverse;

            int finalI = i;
            map.merge(smallerStr, i, (n1, n2) -> Math.min(n1, finalI));
            dj.union(i, map.get(smallerStr));
        }

        System.out.println(dj.numOfGroup());
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
