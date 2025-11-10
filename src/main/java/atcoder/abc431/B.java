
package atcoder.abc431;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();
        int n = sc.nextInt();

        int w[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        boolean used[] = new boolean[n];

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;

            if(!used[index]) {
                weight += w[index];
                used[index] = true;
            }
            else {
                weight -= w[index];
                used[index] = false;
            }

            System.out.println(weight);
        }

    }
}