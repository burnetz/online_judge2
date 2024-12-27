package atcoder.abc385;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] h = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int result = 1;
        //見た目上3重ループだが適切にbreakすれば間に合う。
        for(int i = 0; i < n; i++) {
            for(int d = 1; d <= n - 1; d++) {
                int count = 1;
                for(int j = i + d; j < n; j += d) {
                    if(h[i] != h[j]) {
                        break;
                    }

                    count++;
                }

                result = Math.max(count, result);
            }
        }

        System.out.println(result);
    }
}