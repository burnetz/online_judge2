package atcoder.abc330;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //Nが200000までなので極端に大きな値はそもそもMEXになりえない。
        //そこでlimit以下の数字だけ真面目に個数を管理する。
        int limit = 300002;
        int count[] = new int[limit + 1];
        //SortedSetで管理すればMEX候補の追加と削除が容易。
        //実際のMEXはfirst()で取得できる。
        SortedSet<Integer> set = new TreeSet<>();
        Arrays.stream(a).forEach(e -> {if(e <= limit) count[e]++;});

        for(int i = 0; i <= limit; i++) {
            if(count[i] == 0) {
                set.add(i);
            }
        }

        for(int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;
            int x = sc.nextInt();

            if(a[index] <= limit) {
                count[a[index]]--;
                if (count[a[index]] == 0) {
                    set.add(a[index]);
                }
            }
            if(x <= limit) {
                a[index] = x;
                count[x]++;
                set.remove(x);
            }
            //limitより大きいときは漠然と大きな値として取り扱う。
            else {
                a[index] = Integer.MAX_VALUE;
            }

            System.out.println(set.first());
        }
    }
}
