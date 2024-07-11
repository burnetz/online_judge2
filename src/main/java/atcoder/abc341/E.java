package atcoder.abc341;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        String str = sc.next();

        StateAddSegmentTree seg = new StateAddSegmentTree(n);

        //010101...に従うことを状態0, 101010....に従うことを状態1とする。
        for(int i = 0; i < n; i++) {
            seg.add(i, i + 1, str.charAt(i) - '0' == i % 2 ? 0 : 1);
        }

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            int l = sc.nextInt() - 1;
            int r = sc.nextInt();

            if(mode == 1) {
                seg.add(l, r, 1);
            }
            else {
                int status = seg.status(l, r);

                if(status != seg.MIXED) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
        }
    }
}

//
class StateAddSegmentTree {
    //区間の状態を保存する。奇数のみ、偶数のみ、混在、初期化していないor範囲外の4通りのステータスが存在する。
    private int segment[];
    int ODD_ONLY = 0;
    int EVEN_ONLY = 1;
    int MIXED = 2;
    int NOT_INITIALIZED = 3;
    private long lazy[];
    private boolean lazyFlag[];
    private static final int ROOT_NODE = 1;
    private int ub;

    StateAddSegmentTree(int n) {
        this(n, 2147483647);
    }
    StateAddSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new int[ub * 2];
        lazy = new long[ub * 2];
        Arrays.fill(segment, NOT_INITIALIZED);
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
            lazy[node] %= 2;

            //まだ初期化されていない区間であれば加算ではなく初期化として扱う。
            if(segment[node] == NOT_INITIALIZED) {
                if(lazy[node] == 0) {
                    segment[node] = EVEN_ONLY;
                }
                else {
                    segment[node] = ODD_ONLY;
                }
            }
            else if(segment[node] == ODD_ONLY) {
                if(lazy[node] == 1){
                    segment[node] = EVEN_ONLY;
                }
            }
            else if(segment[node] == EVEN_ONLY){
                if(lazy[node] == 1) {
                    segment[node] = ODD_ONLY;
                }
            }

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
            if(segment[node*2] == segment[node*2 + 1] && segment[node*2] != MIXED) {
                segment[node] = segment[node*2];
            }
            else {
                segment[node] = MIXED;
            }
        }
        // if not overlap, do nothing
        return;
    }

    int status(int start, int end) {
        return status(start, end, ROOT_NODE, 0, ub);
    }

    private int status(int start, int end, int node, int targetStart, int targetEnd) {
        lazyEvaluate(node, targetStart, targetEnd);
        if(is_contain(targetStart, targetEnd, start, end)) {
            return segment[node];
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            int resultL = status(start, end, node * 2, lStart, lEnd);
            int resultR = status(start, end, node * 2 + 1, rStart, rEnd);

            if(resultL == NOT_INITIALIZED) {
                return resultR;
            }
            else if(resultR == NOT_INITIALIZED) {
                return resultL;
            }

            if(resultL != MIXED && resultL == resultR) {
                return resultL;
            }
            else {
                return  MIXED;
            }

        }
        // if not overlap, do nothing
        return NOT_INITIALIZED;
    }
}