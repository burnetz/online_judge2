package atcoder.abc339;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int limit = 500000;

        //Range Max Queryに対応した平方分割のデータ構造を利用する。
        SqrtDecompositionRMQRUQ dec = new SqrtDecompositionRMQRUQ(limit + 1);

        dec.update(a[0], a[0] + 1, 1);

        for(int i = 1; i < n ; i++) {
            int left = Math.max(a[i] - d, 0);
            int right = Math.min(a[i] + d, limit) + 1;

            int tmp = (int)dec.findMax(left, right);
            if(dec.get(a[i]) < tmp + 1) {
                dec.update(a[i], a[i] + 1, tmp + 1);
            }
        }

        int result = (int)dec.findMax(1, limit + 1);

        System.out.println(result);

    }
}

class SqrtDecompositionRMQRUQ {
    int N, K;
    long[] data;
    long[] bucketMax;
    long[] bucketLazyUpdate;
    //若干チューニングが必要な箇所。sqrt(500000)に近い値を使うと比較的高速になる。
    //512にするとTLEになる。
    static final int sqrtN = 768;
    static final int NIL = Integer.MIN_VALUE;

    public SqrtDecompositionRMQRUQ(int n) {
        N = n;
        K = (N + sqrtN - 1) / sqrtN;
        data = new long[K * sqrtN];
        bucketLazyUpdate = new long[K];
        Arrays.fill(bucketLazyUpdate, NIL);
        bucketMax = new long[K];
    }

    // [s, t)
    void update(int s, int t, int x) {
        for (int k = 0; k < K; ++k) {
            int l = k * sqrtN, r = (k + 1) * sqrtN;
            if (r <= s || t <= l)
                continue;
            if (s <= l && r <= t) {
                bucketLazyUpdate[k] = x;
                bucketMax[k] = x;
            } else {
                if(bucketLazyUpdate[k] != NIL){
                    for(int i = l; i < r; i++){
                        data[i] = bucketLazyUpdate[k];

                    }
                    bucketLazyUpdate[k] = NIL;
                }
                for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
                    data[i] = x;
                }
                bucketMax[k] = NIL;
                for(int i = l; i < r; i++){
                    bucketMax[k] = Math.max(bucketMax[k], data[i]);
                }
            }
        }
    }

    long findMax(int s, int t) {
        long result = NIL;
        for (int k = 0; k < K; ++k) {
            int l = k * sqrtN, r = (k + 1) * sqrtN;
            if (r <= s || t <= l)
                continue;
            if (s <= l && r <= t) {
                result = Math.max(result, bucketMax[k]);
            }
            else {
                if(bucketLazyUpdate[k] != NIL){
                    result = Math.max(result, bucketLazyUpdate[k]);
                }
                else {
                    for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
                        result = Math.max(result, data[i]);
                    }
                }
            }
        }

        return result;
    }

    long get(int s) {
        int k = s / sqrtN;
        if(bucketLazyUpdate[k] != NIL){
            return bucketLazyUpdate[k];
        }
        else {
            return data[s];
        }
    }
}