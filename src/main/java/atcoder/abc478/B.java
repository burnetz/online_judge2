
package atcoder.abc478;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int v = sc.nextInt();

        int[] w = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(i + 1 + j + 1 + k + 1 > v) {
                        continue;
                    }

                    result = Math.max(result, w[i] + w[j] + w[k]);
                }
            }
        }

        System.out.println(result);
    }
}