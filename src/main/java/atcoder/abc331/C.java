package atcoder.abc331;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n];
        int count[] = new int[1_000_002];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            count[a[i]]++;
        }

        long sum[] = new long[1_000_002];
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + (long)i*count[i];
        }

        for(int i = 0; i < n; i++) {
            System.out.print(sum[1_000_001] - sum[a[i]] + " ");
        }
    }
}
