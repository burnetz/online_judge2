
package atcoder.abc475;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int n100 = 0;
        int n10 = 0;
        int n1 = 0;

        for(int i = 0; i < n; i++) {
            int tmp = 1000 - a[i] % 1000;

            n100 += tmp % 1000 / 100;
            n10 += tmp % 100 / 10;
            n1 += tmp % 10;
        }

        System.out.println(n1 + " " + n10 + " " + n100);
    }
}