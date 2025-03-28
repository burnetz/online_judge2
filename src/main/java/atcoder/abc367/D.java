package atcoder.abc367;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long result = 0;

        int sumMod = 0;
        for(int i = 0; i < n; i++) {
            sumMod += a[i];
            sumMod %= m;
        }

        //中間部分の合計で作られる方は難なく求められるが
        //問題は中間部分を引くことで作られる方。
        for(int i = 0; i < 2; i++) {
            //前者が中間の和、後者が中間を引いた和を求めるための余りの値
            int modArray[] = {m, sumMod};

            int dp[] = new int[m];
            long tmpSum = 0;
            for(int j = 0; j < n; j++) {
                tmpSum += a[j];

                int tmpMod = (int)(tmpSum % m);

                int dpIndex = (tmpMod + m - modArray[i]) % m;

                result += dp[dpIndex];
                dp[tmpMod]++;

            }
        }

        System.out.println(result);
    }
}