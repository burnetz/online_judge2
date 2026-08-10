
package atcoder.abc470;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        int max = Arrays.stream(count).max().getAsInt();

        System.out.println(n - max);
    }
}