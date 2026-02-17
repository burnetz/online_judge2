package atcoder.abc444;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = Arrays.stream(new long[n]).map(e -> sc.nextInt()).sorted().toArray();

        if(n == 1) {
            System.out.println(a[0]);
            return;
        }

        //作ることができるのはmax(a)かmax(a)+min(a)のいずれかのみ。
        int l = 0;
        int r = n - 1;
        //足さなくてもmax(a)と等しいものはスキップ
        while(r >= 0 && a[r] == a[n - 1]) {
            r--;
        }

        boolean isOk = true;
        //残りが奇数個の場合ペアを作れない
        if((r - l) % 2 == 0) {
            isOk = false;
        }
        while(l < r) {
            if(a[l] + a[r] != a[n - 1]) {
                isOk = false;
                break;
            }

            l++;
            r--;
        }

        if(isOk) {
            System.out.print(a[n - 1] + " ");
        }

        //ここから先はmin(a)+max(a)を作れるかを調べる。
        if(n % 2 == 1) {
            return;
        }

        l = 0;
        r = n - 1;
        isOk = true;
        while (l < r) {
            if(a[l] + a[r] != a[0] + a[n - 1]) {
                isOk = false;
                break;
            }
            l++;
            r--;
        }

        if(isOk) {
            System.out.println(a[0] + a[n - 1]);
        }

    }
}