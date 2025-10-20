package atcoder.abc428;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();

        int result = 0;
        while(x > 0) {
            int tmp = Math.min(a, x);

            result += s * tmp;
            x -= tmp;

            tmp = Math.min(b, x);
            x -= tmp;

        }

        System.out.println(result);
    }
}