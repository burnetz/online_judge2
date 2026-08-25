
package atcoder.abc472;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] l = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int sum = Arrays.stream(l).sum();

        int left = l[0];
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            result = Math.min(result, Math.abs(sum - 2 * left));
            left += l[i];
        }

        System.out.println(result);

    }
}