
package atcoder.abc466;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int sizes[] = new int[m + 1];
        Arrays.fill(sizes, -1);

        for(int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int s = sc.nextInt();

            sizes[c] = Math.max(sizes[c], s);
        }

        for(int i = 0; i < m; i++) {
            System.out.print(sizes[i + 1] + " ");
        }
    }
}