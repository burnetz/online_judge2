package atcoder.abc416;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int start = -1;

        char t[] = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                start = i;
                t[i] = 'o';
                break;
            }
        }

        for(int i = start; i < s.length(); i++) {
            boolean sharpAppear = false;
            for(int j = i + 1; j < s.length(); j++) {
                if(sharpAppear && s.charAt(j) == '.') {
                    i = j - 1;
                    t[j] = 'o';
                    break;
                }
                else if(s.charAt(j) == '#') {
                    sharpAppear = true;
                }
            }
        }

        System.out.println(t);
    }
}