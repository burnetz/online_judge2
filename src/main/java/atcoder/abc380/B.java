package atcoder.abc380;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int current = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '|') {
                System.out.print(current + " ");
                current = 0;
            }
            else {
                current++;
            }
        }
    }
}