package atcoder.abc318;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt() - 1;
        }

        //それぞれの数字の出現箇所を記録するためのリスト
        ArrayList<Long>[] lists = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            lists[a[i]].add((long)i);
        }

        long result = 0;
        //同じ数字どうしで間がいくつ空いてるかが重要になる。
        //ある区間の数字に対して左右の数字を選ぶ自由度があるので重み付けに注意する。
        //見た目はO(N^2)だがリスト内には要素がN個しかないのでO(N)でできる。
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < lists[i].size() ; j++) {
                result += ((long)j * ((lists[i].size() - 1) - j + 1)) * ((lists[i].get(j) - lists[i].get(j - 1) - 1));
            }
        }

        System.out.println(result);

    }
}
