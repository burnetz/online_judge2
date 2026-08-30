
package atcoder.abc473;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int count[] = new int[101];
        for(int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            if(count[i] % 2 == 1) {
                sum += i;
            }
        }

        System.out.println(sum);


    }
}