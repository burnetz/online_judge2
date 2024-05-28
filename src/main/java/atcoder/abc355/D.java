package atcoder.abc355;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Range[] ranges = new Range[n + 1];
        for(int i = 0; i < n; i++) {
            ranges[i] = new Range(sc.nextInt(), sc.nextInt());
        }
        //番兵
        ranges[n] = new Range(1_000_000_001, 1_000_000_001);

        //あらかじめ区間の左端についてソートしておけば被る区間を2分探索で求められる。
        Arrays.sort(ranges, Comparator.comparingInt(value -> value.l));

        long result = 0;
        for(int i = 0; i < n - 1; i++) {
            int left = i;
            int right = n + 1;
            int mid = i;
            while(right - left > 1) {
                mid = (left + right) / 2;
                if(ranges[mid].l <= ranges[i].r) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
            result += left - i;
        }

        System.out.println(result);
    }
}

class Range {
    int l;
    int r;

    Range(int l, int r) {
        this.l = l;
        this.r = r;
    }
}