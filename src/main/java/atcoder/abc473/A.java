
package atcoder.abc473;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int sum = Arrays.stream(a, n / 2, n).sum();

        System.out.println(sum);


    }
}