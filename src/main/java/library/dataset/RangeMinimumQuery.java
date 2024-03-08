package library.dataset;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMinimumQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        RMQSegmentTree seg = new RMQSegmentTree(n);
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(mode == 0) {
                seg.setVal(x + 1, y);
            }
            else {
                System.out.println(seg.findMin(x + 1, y + 2));
            }
        }
    }

}

class RMQSegmentTree {
    private int segment[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private int initial;

    RMQSegmentTree(int n) {
        this(n, 2147483647);
    }
    RMQSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new int[ub * 2];
        this.initial = initial;
        Arrays.fill(segment, initial);
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

    void setVal(int index, int val) {
        int node = ub + index;
        segment[node] = val;
        // If necessary, do something on seg[node]
        node /= 2;
        while(node > 0) {
            // do something
            segment[node] = Math.min(segment[node*2], segment[node*2 + 1]);
            node /= 2;
        }
    }

    int findMin(int start, int end) {
        return findMin(start, end, ROOT_NODE, 0, ub);
    }

    private int findMin(int start, int end, int node, int targetStart, int targetEnd) {
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            return segment[node];
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            int result = findMin(start, end, node*2, lStart, lEnd);
            result = Math.min(result, findMin(start, end, node*2+1, rStart, rEnd));

            return result;
        }
        // if not overlap, do nothing
        return initial;
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