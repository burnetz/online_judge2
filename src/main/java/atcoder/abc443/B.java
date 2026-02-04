package atcoder.abc443;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        long sum = 0;

        for(long i = n; ; i++) {
            sum += i;

            if(sum >= k) {
                System.out.println(i - n);
                return;
            }
        }
    }
}