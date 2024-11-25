package atcoder.abc381;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        if(str.length() % 2 == 1) {
            System.out.println("No");
            return;
        }

        int count[] = new int[26];
        for(int i = 0; i < str.length() ; i+=2) {
            if(str.charAt(i) != str.charAt(i + 1)) {
                System.out.println("No");
                return;
            }

            char c = str.charAt(i);

            if(count[c - 'a'] >= 2) {
                System.out.println("No");
                return;
            }

            count[c - 'a'] += 2;
        }

        System.out.println("Yes");
    }
}