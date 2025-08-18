package atcoder.abc416;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt() - 1;
        int r = sc.nextInt() - 1;

        String s = sc.next();

        for(int i = l; i <= r; i++) {
            if(s.charAt(i) == 'x') {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}