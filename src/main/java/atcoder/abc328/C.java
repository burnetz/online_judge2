package atcoder.abc328;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String str = sc.next();

        int sum[] = new int[n + 1];

        for(int i = 2; i <= n; i++ ) {
            sum[i] = sum[i - 1];
            if(str.charAt(i - 2) == str.charAt(i - 1)) {
                sum[i]++;
            }
        }

        for(int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(sum[r] - sum[l]);
        }
    }
}
