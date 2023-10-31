package atcoder.abc326;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long a[] = new long[n + 1];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        a[n] = Long.MAX_VALUE;
        Arrays.sort(a);

        int left = 0;
        int right = 0;
        int result = 0;
        while (left < n) {
            if(a[left] + m > a[right + 1]) {
                right++;
            }
            else {
                left++;
            }

            result = Math.max(result, right - left);
        }

        System.out.println(result + 1);
    }
}
