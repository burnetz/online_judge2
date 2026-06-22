package atcoder.abc463;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        if(9 * x == 16 * y) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}