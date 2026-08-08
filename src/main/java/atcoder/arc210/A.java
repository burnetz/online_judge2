package atcoder.arc210;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        RSQRAQSegmentTree tree = new RSQRAQSegmentTree(n, 0);

        //ベースとして1,2,3,...,nの数列を作る。パターンによってはこれがそのまま最終的な数列になる。
        //逆に、これより総和が小さい数列を作ろうとすると初期状態の時点で条件を満たせない。
        for(int i = 0; i < n; i++) {
            tree.add(i, i + 1, i + 1);
        }

        //常に条件を満たすためには1.「a[index]にvalを加算」した後に
        //条件に違反しないよう2.「a[index + 1]以降を均等に底上げ」すれば良い。
        //なお、1.の手順で加算した値は最終的な結果に含めなくて良い。
        long offset = 0;
        for(int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;
            int val = sc.nextInt();

            tree.add(index, index + 1, val);
            offset += val;

            if(index == n - 1) {
                continue;
            }

            long diff = tree.sum(index + 1, index + 2) - tree.sum(index, index + 1);

            if(diff <= 0) {
                tree.add(index + 1, n, -diff + 1);
            }
        }

        System.out.println(tree.sum(0, n) - offset);

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
    RSQRAQSegmentTree(int n, long initial) {
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