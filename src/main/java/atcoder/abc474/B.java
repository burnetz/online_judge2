
package atcoder.abc474;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();

        for(int i = 0; i < n; i += 10) {
            for(int j = i; j < Math.min(n, i + 10); j++) {
                if(a[j] >= i + 10) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");

    }
}