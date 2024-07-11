package library.dataset;

import java.util.Arrays;
import java.util.Scanner;

public class RSQRUQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        RSQRUQSegmentTree seg = new RSQRUQSegmentTree(n, 0);

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            if(mode == 0) {
                int l = sc.nextInt();
                int r = sc.nextInt() + 1;
                int x = sc.nextInt();

                seg.update(l, r, x);
            }
            else {
                int s = sc.nextInt();
                int t = sc.nextInt() + 1;
                System.out.println(seg.sum(s, t));
            }
        }

    }
}

class RSQRUQSegmentTree {
    private long segment[];
    private long lazy[];
    private boolean lazyFlag[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private int initial;
    private int timeStamp = 0;

    RSQRUQSegmentTree(int n) {
        this(n, 2147483647);
    }
    RSQRUQSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new long[ub * 2];
        lazy = new long[ub * 2];
        this.initial = initial;
        Arrays.fill(segment, initial);
        Arrays.fill(lazy, initial);
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

    void update(int start, int end, int val) {
        update(start, end, val, ROOT_NODE, 0, ub);
    }

    private void lazyEvaluate(int node, int l, int r) {
        if(lazyFlag[node]) {
            segment[node] = lazy[node] * (r - l);
            if(r - l > 1) {
                lazy[node*2] = lazy[node*2+1] = lazy[node];
                lazyFlag[node*2] = lazyFlag[node*2+1] = true;
            }
            lazyFlag[node] = false;
        }
    }

    private void update(int start, int end, int val, int node, int targetStart, int targetEnd) {
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            lazy[node] = val;
            lazyFlag[node] = true;
            lazyEvaluate(node, targetStart, targetEnd);
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            update(start, end, val, node*2, lStart, lEnd);
            update(start, end, val, node*2+1, rStart, rEnd);
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
        return initial;
    }

    void printSegment() {
        for(int i = 0; i < segment.length; i++) {
            System.out.println("id : " + i + " value " + segment[i]);
        }
    }


}