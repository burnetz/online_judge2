package atcoder.arc177;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        StringBuffer sb = new StringBuffer();
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                for(int j = 0; j <= i; j++) {
                    sb.append("A");
                }
                for(int j = 0; j < i; j++) {
                    sb.append("B");
                }
            }
        }

        System.out.println(sb.length());
        System.out.println(sb);
    }
}
