package atcoder.arc163;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int a0 = sc.nextInt();
        int a1 = sc.nextInt();
        int a2toN[] = new int[n - 2];

        for(int i = 0; i < n - 2; i++) {
            a2toN[i] = sc.nextInt();
        }

        Arrays.sort(a2toN);

        long result = Long.MAX_VALUE;
        //ソート済みのm個の連続した要素だけを巻き込むのが最適なので
        //貪欲法で解ける。
        for(int i = 0; i <= n - 2 - m; i++) {
            int head = a2toN[i];
            int tail = a2toN[i + m - 1];

            //もともとa0が十分小さい場合やa1が十分大きい場合は調整不要
            long tmpCost = Math.max(0, a0 - head) + Math.max(0, tail - a1);
            result = Math.min(tmpCost, result);
        }

        System.out.println(result);
    }

}
