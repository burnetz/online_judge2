package atcoder.abc404;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int count[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] == 0) {
                System.out.println((char)(i + 'a'));
                return;
            }
        }
    }
}