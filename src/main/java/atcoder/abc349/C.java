package atcoder.abc349;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next().toUpperCase();

        String t = sc.next();

        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(index)) {
                index++;
            }

            if(index == 3 || (index == 2 && t.charAt(2) == 'X')) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");

    }
}