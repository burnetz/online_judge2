package atcoder.abc406;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long display = 1;
        long limit = (long)Math.pow(10, k);

        for(int i = 0; i < n; i++) {
            if(a[i] > limit/display) {
                display = 1;
            }
            else {
                display *= a[i];

                if(display >= limit) {
                    display = 1;
                }
            }
        }

        System.out.println(display);
    }
}