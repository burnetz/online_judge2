
package atcoder.abc475;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt() - 1;
        long l = sc.nextLong();

        long[] a = Arrays.stream(new long[n - 1]).map(e -> sc.nextInt()).toArray();
        long[] fromS = new long[n];
        for(int i = s - 1; i >= 0; i--) {
            fromS[i] = fromS[i + 1] + a[i];
        }

        for(int i = s + 1; i < n; i++) {
            fromS[i] = fromS[i - 1] + a[i - 1];
        }

        int result = 0;
        //Sから見て前のグループと後ろのグループを両方とも選ぶ場合必ず往復が発生する。
        //片道だけで済ませるのが最適なパターンも距離0の往復をしたことにすれば同じループで判定可能。
        //Nが小さいのでO(N^2)で間に合う。
        for(int i = 0; i <= s; i++) {
            for(int j = s; j < n; j++) {
                long direct = Math.max(fromS[i], fromS[j]);
                long round = Math.min(fromS[i], fromS[j]) * 2;
                if(direct + round <= l) {
                    int tmpResult = j - i + 1;

                    result = Math.max(result, tmpResult);
                }
            }
        }

        System.out.println(result);


    }
}