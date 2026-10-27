
package atcoder.abc481;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int count = 0;
        for(int i = 0; i < n ; i++) {
            if(a[i] == k) {
                count++;
            }

            if(i < n - 1 && (a[i] - k) * (a[i + 1] - k) < 0) {
                count++;
            }
        }

        System.out.println(count);



    }
}