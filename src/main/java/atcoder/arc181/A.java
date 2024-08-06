package atcoder.arc181;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

            solve(n, a);
        }
    }

    //どんなパターンでも3ターン以内に終わる
    static void solve(int n, int a[]) {
        //先頭にn, 末尾に1のときは1かnをずらさなければならない。
        //ずらした後は2ターンかかるパターンと同じなので合計3ターン。
        if(a[0] == n && a[n - 1] == 1) {
            System.out.println(3);
            return;
        }
        boolean sorted[] = new boolean[n];
        int dpMin[] = new int[n];
        int dpMax[] = new int[n];

        sorted[0] = a[0] == 1;
        dpMin[0] = dpMax[0] = a[0];
        for(int i = 1; i < n; i++) {
            sorted[i] = sorted[i - 1] && (a[i] == i + 1);
            dpMin[i] = Math.min(dpMin[i - 1], a[i]);
            dpMax[i] = Math.max(dpMax[i - 1], a[i]);
        }

        //最初から完成しているパターン
        if(sorted[n - 1]) {
            System.out.println(0);
            return;
        }
        int result = 2;
        for(int i = 0; i < n; i++) {
            //操作の前後でi番目の要素は変わらない。
            //i番目が既に合っていて左右それぞれをソートすれば済む場合は1ターン
            if(i + 1 == a[i]) {
                if(dpMin[i] == 1 && dpMax[i] == i + 1) {
                    result = 1;
                    break;
                }
            }
        }

        //それ以外の場合はまず1かnを正しい場所に移してから残りをソートすれば良いので合計2ターン。
        System.out.println(result);

    }
}
