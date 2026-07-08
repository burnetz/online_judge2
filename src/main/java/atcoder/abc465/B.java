
package atcoder.abc465;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;
        if(a <= r && b >= l) {
            sum += (Math.min(r, b) - Math.max(l, a)) * x;
        }
        if(a < l) {
            sum += (Math.min(b, l) - a) * y;
        }
        if(b > r) {
            sum += (b - Math.max(a, r)) * y;
        }

        System.out.println(sum);
    }
}