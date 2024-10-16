package atcoder.abc375;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x[] = new long[n + 2];
        long y[] = new long[n + 2];

        for(int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double sum = 0;

        for(int i = 0; i <= n ; i++) {
            long dx = x[i + 1] - x[i];
            long dy = y[i + 1] - y[i];
            double dist = Math.sqrt(dx*dx + dy*dy);

            sum += dist;

        }

        System.out.println(sum);
    }
}