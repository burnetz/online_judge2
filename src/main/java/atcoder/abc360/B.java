package atcoder.abc360;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        for(int i = 1; i < s.length(); i++) {
            for(int j = 1; j <= i; j++) {
                String tmpStr = "";
                for (int k = j - 1; k < s.length(); k += i) {
                    tmpStr += s.charAt(k);
                }
                if (tmpStr.equals(t)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}