package atcoder.abc433;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        while(true) {
            if (x == y * z) {
                System.out.println("Yes");
                return;
            }

            x++;
            y++;

            if (x < y * z) {
                break;
            }
        }

        System.out.println("No");
    }
}