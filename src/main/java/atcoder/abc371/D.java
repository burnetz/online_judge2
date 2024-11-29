package atcoder.abc371;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] x = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] p = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Village[] villages = new Village[n + 1];
        //ダミーを1ついれておく
        villages[0] = new Village(-2_000_000_000, 0);

        //累積和
        long sum[] = new long[n + 1];
        for(int i = 0; i < n; i++) {
            villages[i + 1] = new Village(x[i], p[i]);
            sum[i + 1] = sum[i] + p[i];
        }

        int q = sc.nextInt();

        //座標でソート済みなので対応する村の範囲をバイナリサーチで特定する。
        //ヒットしたときとしなかったときの扱いに注意。
        for(int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            Village tmp = new Village(l, 0);
            int indexL = Arrays.binarySearch(villages, tmp);
            if(indexL < 0) {
                indexL++;
                indexL *= -1;
            }
            tmp = new Village(r, 0);
            int indexR = Arrays.binarySearch(villages, tmp);
            if(indexR < 0) {
                indexR++;
                indexR *= -1;
                indexR--;
            }

            long result = sum[indexR] - sum[Math.max(indexL - 1, 0)];

            System.out.println(result);
        }
    }
}

class Village implements Comparable<Village> {
    int pos;
    int amount;

    Village(int pos, int amount) {
        this.pos = pos;
        this.amount = amount;
    }


    @Override
    public int compareTo(Village v) {
        return Integer.compare(this.pos, v.pos);
    }
}