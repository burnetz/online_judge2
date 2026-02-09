package atcoder.abc444;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            int tmp = i;
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if(sum == k) {
                count++;
            }
        }

        System.out.println(count);

    }
}