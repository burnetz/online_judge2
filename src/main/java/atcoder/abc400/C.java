package atcoder.abc400;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long result = 0;

        //2^i * a^2 を満たす整数の個数を2分探索で求める。
        //なお、i>=3のとき必ず既存の結果と重複するので高々i<=2でOK
        for(int i = 1; (long)Math.pow(2, i) <= n && i <= 2 ; i++) {
            long l = 1;
            long r = 1_000_000_001;

            while(r - l > 1) {
                long mid = (l + r) / 2;

                if((long)Math.pow(2, i)*mid*mid <= n){
                    l = mid;
                }
                else {
                    r = mid;
                }
            }

            result += l;
        }

        System.out.println(result);
    }
}