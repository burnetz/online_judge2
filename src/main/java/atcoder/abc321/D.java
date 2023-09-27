package atcoder.abc321;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long p = sc.nextInt();

        //後で行うバイナリサーチのために敢えて10倍した値を保存する。
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong() * 10).toArray();
        long b[] = Arrays.stream(new long[m]).map(e -> sc.nextLong() * 10).toArray();

        Arrays.sort(b);
        //bの配列については累積和を求めておく。
        long sumB[] = new long[m];
        for(int i = 0; i < m; i++) {
            if(i != 0) {
                sumB[i] = sumB[i - 1];
            }
            sumB[i] += b[i]/10;
        }

        long result = Arrays.stream(a).map(e -> {
            //10倍の値より少しずらすことで必ずサーチに失敗させる。
            //これによりindexより前が実費、後がセット価格と明確に分けられる。
            int index = Arrays.binarySearch(b, p * 10 - e + 1);
            index = (index + 1) * (-1);

            //いずれにしてもeはm回使う。
            long tmpResult = e * m / 10;
            //実費で計算する部分。
            if(index > 0) {
                tmpResult += sumB[index - 1];
            }
            //セット価格で計算する部分。
            tmpResult += (m - index) * (p - e / 10);

            return tmpResult;
        }).sum();

        System.out.println(result);
    }

}
