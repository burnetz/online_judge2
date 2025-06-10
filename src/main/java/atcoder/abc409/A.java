package atcoder.abc409;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s1 = sc.next();
        String s2 = sc.next();

        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) == 'o' && s2.charAt(i) == 'o') {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}