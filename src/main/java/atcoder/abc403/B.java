package atcoder.abc403;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t = sc.next();
        String u = sc.next();

        for(int i = 0; i <= t.length() - u.length(); i++) {
            for(int j = 0; j < u.length(); j++) {
//                System.out.println("i = " + i + " j = " + j);
                if(t.charAt(i + j) != u.charAt(j) && t.charAt(i + j) != '?') {
                    break;
                }

                if(j == u.length() - 1) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}