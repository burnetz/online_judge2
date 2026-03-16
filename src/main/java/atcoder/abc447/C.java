package atcoder.abc447;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while(index1 < s.length() && index2 < t.length()) {
            char c1 = s.charAt(index1);
            char c2 = t.charAt(index2);
//            System.out.println("index1 " + index1 + " index2 " + index2);

            if(c1 == 'A') {
                if(c2 == 'A') {
                    index1++;
                    index2++;

                }
                else {
                    count++;
                    index1++;

                }
            }
            else {
                if(c1 == c2) {
                    index1++;
                    index2++;
                }
                else if(c2 == 'A') {
                    count++;
                    index2++;

                }
                else {
                    System.out.println(-1);
                    return;

                }
            }

        }

        if(index1 < s.length()) {
            while(index1 < s.length()) {
                if(s.charAt(index1) == 'A') {
                    count++;
                    index1++;
                }
                else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        else if(index2 < t.length()) {
            while(index2 < t.length()) {
                if(t.charAt(index2) == 'A') {
                    count++;
                    index2++;
                }
                else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }
}