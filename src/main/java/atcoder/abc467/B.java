
package atcoder.abc467;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String str = sc.next();

            if(str.equals("keep")) {
                sum += b - a;
            }
        }

        System.out.println(sum);

    }
}