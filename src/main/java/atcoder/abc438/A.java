package atcoder.abc438;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int f = sc.nextInt();

        f--;
        while(true) {
            f += 7;

            if(f >= d) {
                System.out.println(f % d + 1);
                return;
            }
        }
    }
}