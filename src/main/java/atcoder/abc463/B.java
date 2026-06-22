package atcoder.abc463;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char c = sc.next().charAt(0);

        for(int i = 0; i < n; i++) {
            if(sc.next().charAt(c - 'A') == 'o') {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}