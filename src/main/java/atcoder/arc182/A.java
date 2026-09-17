package atcoder.arc182;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        p = new int[q];
        v = new int[q];

        for(int i = 0; i < q; i++) {
            p[i] = sc.nextInt() - 1;
            v[i] = sc.nextInt();
        }

        final int FREE = 0;
        final int LEFT = 1;
        final int RIGHT = 2;

        int[] type = new int[q];
        for(int i = q - 1; i >= 0 ; i--) {
            for(int j = 0; j < i ; j++) {
                //主に問題になるのは以前のクエリの方が設定する値が大きいとき
                if(v[j] > v[i]) {
                    //境界の位置も同じ場合は何もできない。
                    if(p[i] == p[j]) {
                        System.out.println(0);
                        return;
                    }
                    //境界がずれているなら、変化の対象が互いに外向きになるような操作なら可能
                    else if(p[i] < p[j]) {
                        //それ以外の操作が既に指定されているなら矛盾
                        if(type[i] == RIGHT || type[j] == LEFT) {
                            System.out.println(0);
                            return;
                        }
                        type[i] = LEFT;
                        type[j] = RIGHT;
                    }
                    else if(p[i] > p[j]) {
                        if(type[i] == LEFT || type[j] == RIGHT) {
                            System.out.println(0);
                            return;
                        }
                        type[i] = RIGHT;
                        type[j] = LEFT;
                    }
                }
            }
        }

        //FREEのままの箇所はどちらの操作をしてもよい。
        long freeCount = Arrays.stream(type).filter(e -> e == FREE).count();

        System.out.println(repeatablePow(2, freeCount, mod));

    }

    static final int mod = 998244353;
    static long[][] dp;
    static int[] p;
    static int[] v;

    static long repeatablePow(int x, long n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }
}
