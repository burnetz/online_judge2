package atcoder.abc441;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int countA = 0;
        int countB = 0;
        //i文字目までのAとBの個数の差を記録する。
        int[] countAMinusB = new int[n];
        int offset = 500_001;
        int treeSize = 500_001 + offset;
        //「countAMinusBの中にK以上の数がいくつあるか」を取得する必要があり、
        //なおかつ更新も発生しDPでは対応できないと思われるためセグメント木を使う。
        RSQRAQSegmentTree segmentTree = new RSQRAQSegmentTree(treeSize, 0);

        for(int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A' -> countA++;
                case 'B' -> countB++;
            }
            countAMinusB[i] = countA - countB;
            int index = countA - countB + offset;
            segmentTree.add(index, index + 1, 1);
        }

        int border = 1;
        long result = 0;
        //i文字目から始まる部分文字列で条件を満たすものの個数は
        //ある基準を超える数字がcountAMinusB内（ただしi番目以降）に現れる回数と一致する。
        for(int i = 0; i < n; i++) {
            long tmp = segmentTree.sum(offset + border, treeSize);

            int index = offset + countAMinusB[i];
            segmentTree.add(index, index + 1, -1);
            result += tmp;

            //今見ている文字によって基準の増減が変わる。
            switch (s.charAt(i)) {
                case 'A' -> border++;
                case 'B' -> border--;
            }
        }

        System.out.println(result);
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