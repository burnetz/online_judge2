package atcoder.abc444;

import java.util.Scanner;
import java.util.TreeSet;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n + 1];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[n] = a[n - 1];

        TreeSet<Integer> set = new TreeSet<>();
        int l = 0;
        int r = 1;
        set.add(a[0]);
        long result = 0;
        //条件を満たす部分列の中であれば更にその部分列も条件を満たす。尺取法を使うことができる。
        //途中の状態をTreeSetで管理するとやりやすい。
        while(l < n) {
            Integer lowerTop = set.lower(a[r]);
            Integer higherBottom = set.higher(a[r]);

            if(set.contains(a[r]) || (lowerTop != null && a[r] - lowerTop < d)
                || (higherBottom != null && higherBottom - a[r] < d)) {
                result += r - l;
                set.remove(a[l]);
                l++;
            }
            else {
                set.add(a[r]);
                r++;
            }
        }

        System.out.println(result);
    }
}