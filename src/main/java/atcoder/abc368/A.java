package atcoder.abc368;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for (int i = n - k ; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        for (int i = 0; i < n - k ; i++) {
            System.out.print(a[i] + " ");
        }
    }
}