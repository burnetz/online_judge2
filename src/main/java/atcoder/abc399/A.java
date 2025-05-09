package atcoder.abc399;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}