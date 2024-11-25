package atcoder.abc381;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        for(int i = 0; i < n / 2; i++) {
            if(str.charAt(i) != '1' || str.charAt(n - i - 1) != '2') {
                System.out.println("No");
                return;
            }
        }

        if(str.charAt(n / 2) != '/') {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
    }
}