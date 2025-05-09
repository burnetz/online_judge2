package atcoder.abc402;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))) {
                System.out.print(s.charAt(i));
            }
        }
    }
}