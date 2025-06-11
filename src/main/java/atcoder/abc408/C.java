package atcoder.abc408;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        RMQRAQSegmentTree seg = new RMQRAQSegmentTree(n, 0);

        for(int i = 0; i < m; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt();

            seg.add(l, r, 1);
        }

        System.out.println(seg.findMin(0, n));

    }
}

class RMQRAQSegmentTree {
    private long segment[];
    private long lazy[];
    private boolean lazyFlag[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private long initial;

    RMQRAQSegmentTree(int n) {
        this(n, 2147483647);
    }
    RMQRAQSegmentTree(int n, int initial) {
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

    void add(int start, int end, int val) {
        add(start, end, val, ROOT_NODE, 0, ub);
    }

    private void lazyEvaluate(int node, int l, int r) {
        if(lazyFlag[node]) {
            segment[node] += lazy[node];
            if(r - l > 1) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
                lazyFlag[node*2] = lazyFlag[node*2+1] = true;
            }
            lazy[node] = 0;
            lazyFlag[node] = false;
        }
    }

    private void add(int start, int end, int val, int node, int targetStart, int targetEnd) {
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            lazy[node] += val;
            lazyFlag[node] = true;
            lazyEvaluate(node, targetStart, targetEnd);
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            add(start, end, val, node*2, lStart, lEnd);
            add(start, end, val, node*2+1, rStart, rEnd);
            segment[node] = Math.min(segment[node*2], segment[node*2 + 1]);
        }
        // if not overlap, do nothing
        return;
    }

    long findMin(int start, int end) {
        return findMin(start, end, ROOT_NODE, 0, ub);
    }

    private long findMin(int start, int end, int node, int targetStart, int targetEnd) {
//        System.out.println("start " + start + " end " + end + " ts " + targetStart + " te " + targetEnd);
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            return segment[node];
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            long result;
            long resultL = findMin(start, end, node * 2, lStart, lEnd);
            long resultR = findMin(start, end, node * 2 + 1, rStart, rEnd);

            result = Math.min(resultL, resultR);
            return result;
        }
        // if not overlap, do nothing
        return Long.MAX_VALUE;
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