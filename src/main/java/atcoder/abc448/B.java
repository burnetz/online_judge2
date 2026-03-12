package atcoder.abc448;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int pepper[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        long total = 0;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();

            int tmp = Math.min(b, pepper[a]);

            total += tmp;
            pepper[a] -= tmp;
        }

        System.out.println(total);

    }
}