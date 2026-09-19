package atcoder.abc432;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int LIMIT = 500000;
        int[] count = new int[LIMIT + 1];

        for(int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        //特定の数字の登場回数と、特定の数字について値と登場回数の積を管理するためのセグメント木を用意する。
        //単純な累積和を持つ方法は今回更新が頻繁に発生するため多分使えない。
        RSQRAQSegmentTree segmentTree = new RSQRAQSegmentTree(LIMIT + 1, 0);
        RSQRAQSegmentTree segmentTreeSum = new RSQRAQSegmentTree(LIMIT + 1, 0);
        for(int i = 0; i <= LIMIT ; i++) {
            segmentTree.add(i, i + 1, count[i]);
            segmentTreeSum.add(i, i + 1, count[i] * i);
        }

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    int x = sc.nextInt() - 1;
                    int y = sc.nextInt();

                    int prev = a[x];
                    segmentTree.add(prev, prev + 1, -1);
                    segmentTreeSum.add(prev, prev + 1, -prev);
                    segmentTree.add(y, y + 1, 1);
                    segmentTreeSum.add(y, y + 1, y);
                    a[x] = y;

                }
                case 2 -> {
                    int l = sc.nextInt();
                    int r = sc.nextInt();

                    //lがr以上のときは配列の中身を一切参照する必要がない。
                    if(l >= r) {
                        System.out.println((long)l * n);
                        continue;
                    }

                    //小さい区間と大きい区間はそれぞれlとrとして計算するので登場回数だけ調べる。
                    int lowerNum = (int)segmentTree.sum(0, l + 1);
                    int higherNum = (int)segmentTree.sum(r, LIMIT + 1);

                    long result = (long)lowerNum * l + segmentTreeSum.sum(l + 1, r) + (long)higherNum * r;

                    System.out.println(result);
                }
            }
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

    void add(int start, int end, int val) {
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

    private void add(int start, int end, int val, int node, int targetStart, int targetEnd) {
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