package atcoder.abc386;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();

        String s = sc.next();
        String t = sc.next();

        if(s.equals(t)) {
            System.out.println("Yes");
            return;
        }

        if(s.length() == t.length()) {
            int diffCount = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                }
            }

            if(diffCount > 1) {
                System.out.println("No");
                return;
            }
            else {
                System.out.println("Yes");
                return;
            }
        }

        if(Math.abs(s.length() - t.length()) > 1) {
            System.out.println("No");
            return;
        }

        int d1 = 0;
        int d2 = 0;
        for(int i = 0; i + d1 < s.length() && i + d2 < t.length(); i++) {
            int index1 = i + d1;
            int index2 = i + d2;
            if(s.charAt(index1) != t.charAt(index2)) {
                if(s.length() < t.length()) {
                    d2++;
                }
                else {
                    d1++;
                }
            }
        }

        if(d1 + d2 > 1) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
    }
}