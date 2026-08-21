
package atcoder.abc466;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        //操作回数が2回以上残っているなら「独立した区間を複数選ぶ」「広く選んでから内側を選び直す」のいずれの方法でも最適な方法を実現できるが
        //ラスト1回では途中でロスがあることを覚悟の上で広く取らざるを得ない場面がある。
        //毎回ラスト1回のつもりで操作を行うのが最適。
        //O(NK)だがKが小さいので間に合う。
        for(int i = 0; i < k; i++) {
            //dp[i] : i番目の要素を末尾とする区間の和の最大値
            long dp[] = new long[n + 1];

            long max = 0;
            int maxIndex = 0;
            for(int j = 0; j < n; j++) {
                //自身だけで完結させるか、直前の区間を巻き込むかの二択
                dp[j + 1] = Math.max(b[j] - a[j], (b[j] - a[j]) + dp[j]);

                if(max < dp[j + 1]) {
                    max = dp[j + 1];
                    maxIndex = j;
                }
            }

            if(max == 0) {
                break;
            }

            long tmpSum = 0;
            for(int j = maxIndex ; j >= 0 && tmpSum < dp[maxIndex + 1]; j--) {
                tmpSum += b[j] - a[j];
                int tmp = b[j];
                b[j] = a[j];
                a[j] = tmp;
            }
        }

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
        }

        System.out.println(sum);


    }
}