package atcoder.abc445;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] strings = new String[n];

        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
            maxLen = Math.max(strings[i].length(), maxLen);
        }

        for(int i = 0; i < n; i++) {
            while(strings[i].length() < maxLen) {
                strings[i] = '.' + strings[i] + '.';
            }
            System.out.println(strings[i]);
        }
    }
}