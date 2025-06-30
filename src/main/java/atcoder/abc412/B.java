package atcoder.abc412;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        for(int i = 1; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) {
                if(t.indexOf(s.charAt(i - 1)) == -1) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
    }
}