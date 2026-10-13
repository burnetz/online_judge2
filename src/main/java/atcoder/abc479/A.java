
package atcoder.abc479;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int sum = 0;
        for(int i = 0; i < n; i += 2) {
            sum += a[i];
        }

        System.out.println(sum);
    }
}