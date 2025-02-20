package atcoder.abc371;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        //その数字が最後に出てきたのはいつか
        int lastAppear[] = new int[n + 1];
        Arrays.fill(lastAppear, -1);

        //dp[i] : i番目の文字を末尾とする部分列に対するf(j, i) (0<=j<i)の和
        long dp[] = new long[n];
        dp[0] = 1;
        lastAppear[a[0]] = 0;

        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1;
            //遡って再びa[i]と同じ数字が現れるまでの区間はa[i]によって数字の種類が増える。
            //一方、それより前の区間はa[i]があっても結果が変わらない。
            dp[i] += i - lastAppear[a[i]] - 1;
            lastAppear[a[i]] = i;
        }

        System.out.println(Arrays.stream(dp).sum());

    }
}