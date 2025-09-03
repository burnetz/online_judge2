package atcoder.arc194;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        RSQSegmentTree seg = new RSQSegmentTree(n, 0);

        int index[] = new int[n + 1];

        for(int i = 0; i < n; i++) {
            index[a[i]] = i;
        }

        //降順に末尾から確定させていくのが最適。
        //各数字にとって、自分より右にある小さい数字は必要なスワップの回数、
        //自分より左にある大きい数字は自身のインデックスの減少量と等しい。
        //これらの情報があればコストを計算できるが各数字についてO(N)で調べる時間はないので
        //segment treeを使って全部でO(N log N)になるよう工夫する。
        int biggerLeft[] = new int[n + 1];
        int biggerRight[] = new int[n + 1];
        int smallerRight[] = new int[n + 1];

        for(int i = n; i >= 1; i--) {
            biggerLeft[i] = (int)seg.sum(0, index[i]);
            biggerRight[i] = (int)seg.sum(index[i], n);
            smallerRight[i] = n - index[i] - biggerRight[i] - 1;

            seg.addVal(index[i], 1);
        }

        long result = 0;

        for(int i = n; i >= 1; i--) {
            long tmp = calcSum(index[i] - biggerLeft[i] + 1, smallerRight[i]);

            result += tmp;

        }

        System.out.println(result);
    }

    static long calcSum(int from, int n) {
        return (long)n * (2 * from + n - 1) / 2;
    }
}

class RSQSegmentTree {
    private int segment[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private int initial;

    RSQSegmentTree(int n) {
        this(n, 0);
    }

    RSQSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new int[ub * 2];
        this.initial = initial;
        Arrays.fill(segment, initial);
    }

    private int upperBound(int n) {
        int ub = 1;

        while (ub < n) {
            ub *= 2;
        }
        return ub;
    }

    boolean is_overlap(int start1, int end1, int start2, int end2) {
        return end1 > start2 && end2 > start1;
    }

    boolean is_contain(int start1, int end1, int start2, int end2) {
        return start2 <= start1 && end1 <= end2;
    }

    void addVal(int index, int val) {
        int node = ub + index;
        // If necessary, do something on seg[node]
        while (node > 0) {
            // do something
            segment[node] += val;
            node /= 2;
        }
    }

    long sum(int start, int end) {
        return sum(start, end, ROOT_NODE, 0, ub);
    }

    private long sum(int start, int end, int node, int targetStart, int targetEnd) {
        if (is_contain(targetStart, targetEnd, start, end)) {
            // do something
            return segment[node];
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd) / 2;
            int rStart = (targetStart + targetEnd) / 2;
            int rEnd = targetEnd;
            long result = sum(start, end, node * 2, lStart, lEnd);
            result += sum(start, end, node * 2 + 1, rStart, rEnd);

            return result;
        }
        // if not overlap, do nothing
        return initial;
    }
}