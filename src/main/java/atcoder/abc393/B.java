package atcoder.abc393;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        String str = sc.next();
        for(int i = 0; i < str.length(); i++) {
            for(int d = 1; i + 2*d < str.length(); d++) {
                if(str.charAt(i) == 'A' && str.charAt(i + d) == 'B' && str.charAt(i + 2*d) == 'C') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}