package library.dataset;

import java.util.Arrays;
import java.util.Scanner;

public class RangeUpdateQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        RUQSegmentTree seg = new RUQSegmentTree(n);

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            if(mode == 0) {
                int l = sc.nextInt();
                int r = sc.nextInt() + 1;
                int x = sc.nextInt();

                seg.update(l, r, x);
            }
            else {
                int index = sc.nextInt();
                System.out.println(seg.get(index));
            }
        }

    }
}

class RUQSegmentTree {
    private int segment[];
    //private int lazy[];
    private int updatedTime[];
    private static final int ROOT_NODE = 1;
    private int ub;
    private int initial;
    private int timeStamp = 0;

    RUQSegmentTree(int n) {
        this(n, 2147483647);
    }
    RUQSegmentTree(int n, int initial) {
        ub = upperBound(n + 1);
        segment = new int[ub * 2];
        this.initial = initial;
        Arrays.fill(segment, initial);
        updatedTime = new int[ub * 2];
        Arrays.fill(updatedTime, timeStamp);
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

    private void update(int start, int end, int val, int node, int targetStart, int targetEnd) {
        if(is_contain(targetStart, targetEnd, start, end)) {
            // do something
            segment[node] = val;
            updatedTime[node] = ++timeStamp;
        } else if (is_overlap(start, end, targetStart, targetEnd)) {
            int lStart = targetStart;
            int lEnd = (targetStart + targetEnd)/2;
            int rStart = (targetStart + targetEnd)/2;
            int rEnd = targetEnd;
            update(start, end, val, node*2, lStart, lEnd);
            update(start, end, val, node*2+1, rStart, rEnd);
        }
        // if not overlap, do nothing
        return;
    }

    int get(int idx) {
        int node = ub + idx;
        // If necessary, do something on seg[node]
        int ans = initial;
        int currentTime = 0;
        while(node > 0) {
            // do something
            if(currentTime < updatedTime[node]) {
                ans = segment[node];
                currentTime = updatedTime[node];
            }
            node /= 2;
        }
        return ans;
    }

    void printSegment() {
        for(int i = 0; i < segment.length; i++) {
            System.out.println("id : " + i + " value " + segment[i] + " time " + updatedTime[i]);
        }
    }
}