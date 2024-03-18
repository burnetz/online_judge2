package atcoder.arc174;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();
        long sum = Arrays.stream(a).sum();

        //それぞれi文字目を終端とした場合の区間和の最大値と最小値
        long dpMax[] = new long[n];
        long dpMin[] = new long[n];

        dpMax[0] = dpMin[0] = a[0];

        for(int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] + a[i], a[i]);
            dpMin[i] = Math.min(dpMin[i - 1] + a[i], a[i]);

        }

        //何もしない方が良い場合はこれがそのまま答えになる。
        long result = sum;
        if(c > 0) {
            long max = Arrays.stream(dpMax).max().getAsLong();
            //操作をした方が良いパターン
            if(max > 0) {
                result = sum + (c - 1) * max;
            }
        }
        else {
            long min = Arrays.stream(dpMin).min().getAsLong();
            //操作をした方が良いパターン
            if(min <= 0) {
                result = sum + (c - 1) * min;
            }
        }

        System.out.println(result);
    }


}
