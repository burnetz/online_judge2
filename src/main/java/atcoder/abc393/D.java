package atcoder.abc393;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char str[] = sc.next().toCharArray();

        //イメージとしてはあるインデックスを境に左にある1と右にある1をすべて中央に寄せる。
        //そのために特定のインデックスまでの1の個数とインデックスの和をメモする必要がある。
        int oneCountL[] = new int[n];
        int oneCountR[] = new int[n + 1];
        long indexSumL[] = new long[n];
        long indexSumR[] = new long[n + 1];

        for(int i = 0; i < n; i++) {
            if(i >= 1) {
                oneCountL[i] = oneCountL[i - 1];
                indexSumL[i] = indexSumL[i - 1];
            }

            if(str[i] == '1') {
                oneCountL[i]++;
                indexSumL[i] += i;
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            if(i < n - 1) {
                oneCountR[i] = oneCountR[i + 1];
                indexSumR[i] = indexSumR[i + 1];
            }

            if(str[i] == '1') {
                oneCountR[i]++;
                indexSumR[i] += i;
            }
        }

        //厳密には「左側に何もない」という状況を試していないが
        //仮に一番左が0であればそこまで1を移すのは最適ではないため一応無視できる。
        long result = Long.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            long leftSum = sumSteps(i + 1 - oneCountL[i], i) - indexSumL[i];
            long rightSum = indexSumR[i + 1] - sumSteps(i + 1, i + oneCountR[i + 1]);

            result = Math.min(result, leftSum + rightSum);
        }

        System.out.println(result);

    }

    //公差1の等差数列の和
    static long sumSteps(int from, int to) {
        return (long)(to + from) * (to - from + 1) / 2;
    }
}