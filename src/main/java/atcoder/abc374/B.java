package atcoder.abc374;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        for(int i = 0; i < Math.max(s.length(), t.length()); i++) {
            char c1 = i < s.length() ? s.charAt(i) : 'X';
            char c2 = i < t.length() ? t.charAt(i) : 'X';

            if(c1 != c2) {
                System.out.println(i + 1);
                return;
            }

        }

        System.out.println(0);
    }
}