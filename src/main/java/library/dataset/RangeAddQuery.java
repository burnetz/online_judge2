package library.dataset;

import java.util.Scanner;

public class RangeAddQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        RAQSegmentTree seg = new RAQSegmentTree(n);

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            if(mode == 0) {
                int l = sc.nextInt();
                int r = sc.nextInt() + 1;
                int x = sc.nextInt();

                seg.add(l, r, x);

//                System.out.println("i = " + i);
//                for(int j = 1; j <= n; j++) {
//                    System.out.println(seg.get(j));
//                }
            }
            else {
                int index = sc.nextInt();
                System.out.println(seg.get(index));
            }


        }


    }
}

class RAQSegmentTree {
    private int segment[];
    private static final int ROOT_NODE = 1;
    private int ub;

    RAQSegmentTree(int n) {
        ub = upperBound(n + 1);
        segment = new int[ub * 2];
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

    private void add(int start, int end, int val, int node, int targetStart, int targetEnd) {
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            segment[node] += val;
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            add(start, end, val, node*2, lStart, lEnd);
            add(start, end, val, node*2+1, rStart, rEnd);
        }
        // if not overlap, do nothing
        return;
    }

    int get(int idx) {
        int node = ub + idx;
        // If necessary, do something on seg[node]
        int ans = 0;
        while(node > 0) {
            // do something
            ans += segment[node];
            node /= 2;
        }
        return ans;
    }
}