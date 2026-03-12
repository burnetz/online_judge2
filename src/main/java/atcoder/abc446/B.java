package atcoder.abc446;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] used = new boolean[m + 1];
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();

            int result = 0;
            int[] tmpArray = Arrays.stream(new int[l]).map(e -> sc.nextInt()).toArray();
            for(int j = 0; j < l; j++) {
                int target = tmpArray[j];

                if(!used[target]) {
                    result = target;
                    used[target] = true;
                    break;
                }

            }

            System.out.println(result);
        }

    }
}