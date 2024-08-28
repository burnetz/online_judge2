package atcoder.abc368;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long t = 1;

        for(int i = 0; i < n; i++) {
            t += a[i] / 5 * 3;
            a[i] %= 5;

            while(a[i] > 0) {
                if(t % 3 == 0) {
                    a[i] -= 3;
                }
                else {
                    a[i]--;
                }

                t++;
            }

        }

        System.out.println(t - 1);
    }
}