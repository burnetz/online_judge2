
package atcoder.abc473;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();
        int[] num = new int[k];

        for(int i = 0; i < n; i++) {
            num[a[i]]++;
        }

        int max = Arrays.stream(num).max().getAsInt();

        int count = (int)Arrays.stream(num).filter(e -> e >= max - 1).count();

        System.out.println(count);

    }
}