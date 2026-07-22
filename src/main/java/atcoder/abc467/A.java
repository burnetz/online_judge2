
package atcoder.abc467;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        if(w * 10000 >= 25 * h * h) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}