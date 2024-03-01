package atcoder.abc340;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int b[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        //Range Add Queryに対応したデータ構造があればやりたいことはひと通りできる。
        SqrtDecomposition dec = new SqrtDecomposition(n);
        for(int i = 0; i < n; i++) {
            dec.add(i, i + 1, a[i]);
        }

        for(int i = 0; i < m; i++) {
            //指定された場所からすべて取り出す（減算で表現できる）
            long tmp = dec.get(b[i]);
            dec.add(b[i], b[i] + 1, -tmp);

            //n個まとめて加算することが何回できるか
            long times = tmp / n;
            dec.add(0, n, times);
            tmp %= n;

            //端数について考える。まずはb[i]よりも後の要素について
            int nAhead = (int)Math.min(tmp, n - b[i] - 1);
            if(b[i] != n - 1) {
                dec.add(b[i] + 1, b[i] + 1 + nAhead, 1);
            }

            //上の処理でなお余る場合は0番目から
            tmp -= nAhead;

            if(tmp != 0) {
                dec.add(0, (int)tmp, 1);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(dec.get(i) + " ");
        }
        System.out.println(sb);
    }
}

class SqrtDecomposition {
    int N, K;
    long[] data;
    long[] bucketAdd;
    static final int sqrtN = 512;

    public SqrtDecomposition(int n) {
        N = n;
        K = (N + sqrtN - 1) / sqrtN;
        data = new long[K * sqrtN];
        bucketAdd = new long[K];
    }

    void add(int s, int t, long x) {
        for (int k = 0; k < K; ++k) {
            int l = k * sqrtN, r = (k + 1) * sqrtN;
            if (r <= s || t <= l)
                continue;
            if (s <= l && r <= t) {
                bucketAdd[k] += x;
            } else {
                for (int i = Math.max(s, l); i < Math.min(t, r); ++i) {
                    data[i] += x;
                }
            }
        }
    }

    long get(int s) {
        int k = s / sqrtN;
        return data[s] + bucketAdd[k];
    }
}