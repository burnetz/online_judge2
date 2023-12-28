package atcoder.arc135;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long s[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        long a[] = new long[n + 2];

        //問題の条件から得られる制約条件として
        //a[i + 3] = s[i + 1] - s[i] + a[i]なので
        //a[0] = a[1] = a[2] = 0として一旦数列を作る。
        for(int i = 0; i < n - 1; i++) {
            a[i + 3] = s[i + 1] - s[i] + a[i];
        }

        //負の数は使えないので上の関係式を維持しつつ底上げする。
        long min[] = Arrays.stream(new long[3]).map(e -> Long.MAX_VALUE).toArray();
        for(int i = 0; i < n + 2; i++) {
            int index = i % 3;
            min[index] = Math.min(min[index], a[i]);
        }

        for(int i = 0; i < n + 2; i++) {
            int index = i % 3;
            if(min[index] < 0) {
                a[i] -= min[index];
            }
        }

        //この時点で各s[i]はa[i] + a[i + 1] + a[i + 2]から全て一定数だけずれている。
        long diff = s[0] - (a[0] + a[1] + a[2]);
        //すでにa[i] + a[i + 1] + a[i + 2]がオーバーしているなら不可（負数での補正ができないため）
        if(diff < 0) {
            System.out.println("No");
            return;
        }

        //インデックスが3k, 3k + 1, 3k + 2のどのグループを選んで補正しても全てのs[i]が均一に底上げされる。
        //今回は3kのグループを選ぶ。
        for(int i = 0; i < n + 2; i += 3) {
            a[i] += diff;
        }
        System.out.println("Yes");
        Arrays.stream(a).forEach(ai -> {
            System.out.print(ai + " ");
        });

    }
}
