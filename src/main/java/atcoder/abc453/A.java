package atcoder.abc453;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != 'o') {
                System.out.println(s.substring(i));
                return;
            }
        }
    }
}