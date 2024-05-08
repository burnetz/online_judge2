package atcoder.abc352;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            for(; index < t.length(); index++) {
                if(s.charAt(i) == t.charAt(index)) {
                    System.out.print((index + 1) + " ");
                    index++;
                    break;
                }
            }
        }

    }
}