package atcoder.arc206;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Vector<Integer>[] vectors = new Vector[n + 1];
        for(int i = 0; i <= n; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < n; i++) {
            vectors[a[i]].add(i);
        }

        //何もしないパターンも含むので1で初期化
        long result = 1;

        for(int i = 0; i < n; i++) {
            //直前も同じ要素なら既に考慮済みなのでスキップ
            if(i >= 1 && a[i] == a[i - 1]) {
                continue;
            }
            int index = Collections.binarySearch(vectors[a[i]], i + 1);

            if(index < 0) {
                index++;
                index *= -1;
            }

            //i以降に存在するa[i]の個数
            int tmp = vectors[a[i]].size() - index;

            result += n - i - tmp - 1;
        }

        System.out.println(result);

    }

}
