
package atcoder.abc468;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int count = 0;

        for(int i = 0; i < n - 2; i++) {
            if(a[i] < a[i + 1] && a[i + 1] > a[i + 2]) {
                count++;
            }
        }

        System.out.println(count);
    }
}