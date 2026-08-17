
package atcoder.abc471;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a + b == 9 || a - b == 9 || a * b == 9 || a == b * 9) {
            System.out.println("Nine");
        }
        else {
            System.out.println("Nein");
        }

    }
}