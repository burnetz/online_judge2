package atcoder.abc382;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        double b[] = Arrays.stream(new double[m]).map(e -> sc.nextInt()).toArray();

        double minA[] = new double[n];
        minA[0] = a[0];
        for(int i = 1; i < n; i++) {
            minA[i] = Math.min(a[i], minA[i - 1]);
        }

        //標準のバイナリサーチだと降順に対応できないので
        //若干わかりづらいが逆順の配列を作る。
        double minAReverse[] = new double[n];
        for(int i = 0; i < n; i++) {
            minAReverse[i] = minA[n - i - 1];
        }

        for(int i = 0; i < m; i++) {
            //敢えて絶対にヒットしないよう0.5ずらす。
            //もしもヒットしてしまうと同じ値が複数存在したときに端を参照する保証が無い。
            int index = Arrays.binarySearch(minAReverse, b[i] + 0.5);

            index++;
            index *= -1;

            if(index > 0) {
                System.out.println(n - index + 1);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}