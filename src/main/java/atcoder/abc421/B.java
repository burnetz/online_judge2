package atcoder.abc421;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a[] = new long[10];
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();

        for(int i = 2; i < 10; i++) {
            long tmp = a[i - 2] + a[i - 1];

            a[i] = Long.parseLong(new StringBuffer(Long.toString(tmp)).reverse().toString());
        }

        System.out.println(a[9]);
    }
}