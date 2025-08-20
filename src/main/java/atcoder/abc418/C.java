package atcoder.abc418;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //個数についてソートして累積和も求めておく
        double a[] = Arrays.stream(new double[n]).map(e -> sc.nextInt()).sorted().toArray();
        long sum[] = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (long)a[i - 1];
        }

        for(int i = 0; i < q; i++) {
            int b = sc.nextInt();

            //lower_boundが無いのでわざと外すようにサーチする。
            int index = Arrays.binarySearch(a, b - 0.5);
            index++;
            index *= -1;

            if(index == n) {
                System.out.println(-1);
                continue;
            }

            //最初の嫌がらせは個数がb未満のものだけを選ぶこと
            long result = sum[index];

            //次の嫌がらせは個数がb以上あるところからb-1個ずつ選ぶこと。
            //ここで1追加すれば必ずb個取り出せる。
            result += ((long)n - index) * (b - 1) + 1;

            System.out.println(result);
        }
    }
}