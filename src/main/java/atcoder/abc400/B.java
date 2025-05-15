package atcoder.abc400;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        int m = sc.nextInt();

        long inf = 1_000_000_000;
        long sum = 0;
        long tmp = 1;
        for(int i = 0; i <= m; i++) {
            sum += tmp;

            if(sum > inf) {
                System.out.println("inf");
                return;
            }

            tmp *= n;
        }

        System.out.println(sum);
    }
}