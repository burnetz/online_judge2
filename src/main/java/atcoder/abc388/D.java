package atcoder.abc388;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //Range Add Queryが使えるとこのあとの処理がやりやすい。
        RSQRAQSegmentTree segTree = new RSQRAQSegmentTree(n, 0);

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        for(int i = 0; i < n; i++) {
            segTree.add(i, i + 1, a[i]);
        }

        //順番を変えて考える。
        //成人後のiが石を何人に分け与えることができるかは成人の時点で確定しているので
        //まとめて対象者に1個ずつ加算する。
        for(int i = 0; i < n - 1; i++) {
            long current = segTree.sum(i, i + 1);
            long move = Math.min(current, n - i - 1);

            //自分の分は減らす。
            segTree.add(i, i + 1, -move);
            segTree.add(i + 1, (int)Math.min(n, i + move + 1), 1);
        }

        for(int i = 0; i < n; i++) {
            System.out.print(segTree.sum(i, i + 1) + " ");
        }
    }
}

class RSQRAQSegmentTree {
    private long segment[];
    private long lazy[];
    private boolean lazyFlag[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private long initial;

    RSQRAQSegmentTree(int n) {
        this(n, 2147483647);
    }
    RSQRAQSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new long[ub * 2];
        lazy = new long[ub * 2];
        this.initial = initial;
        Arrays.fill(segment, initial);
        Arrays.fill(lazy, 0);
        lazyFlag = new boolean[ub * 2];
    }
    private int upperBound(int n) {
        int ub = 1;

        while(ub < n) {
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

    void add(int start, int end, long val) {
        add(start, end, val, ROOT_NODE, 0, ub);
    }

    private void lazyEvaluate(int node, int l, int r) {
        if(lazyFlag[node]) {
            segment[node] += lazy[node];
            if(r - l > 1) {
                lazy[node*2] += lazy[node] / 2;
                lazy[node*2+1] += lazy[node] / 2;
                lazyFlag[node*2] = lazyFlag[node*2+1] = true;
            }
            lazy[node] = 0;
            lazyFlag[node] = false;
        }
    }

    private void add(int start, int end, long val, int node, int targetStart, int targetEnd) {
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            lazy[node] += val * (targetEnd - targetStart);
            lazyFlag[node] = true;
            lazyEvaluate(node, targetStart, targetEnd);
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            add(start, end, val, node*2, lStart, lEnd);
            add(start, end, val, node*2+1, rStart, rEnd);
            segment[node] = segment[node*2] + segment[node*2 + 1];
        }
        // if not overlap, do nothing
        return;
    }

    long sum(int start, int end) {
        return sum(start, end, ROOT_NODE, 0, ub);
    }

    private long sum(int start, int end, int node, int targetStart, int targetEnd) {
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            return segment[node];
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            long result;
            long resultL = sum(start, end, node * 2, lStart, lEnd);
            long resultR = sum(start, end, node * 2 + 1, rStart, rEnd);

            result = resultL + resultR;
            return result;
        }
        // if not overlap, do nothing
        return 0;
    }

    void printSegment() {
        System.out.println("SEGMENT : ");
        for(int i = 1; i < segment.length; i++) {
            System.out.println("id : " + i + " value " + segment[i]);
        }
    }

    void printLazy() {
        System.out.println("LAZY : ");
        for(int i = 1; i < lazy.length; i++) {
            System.out.println("id : " + i + " value " + lazy[i]);
        }
    }
}