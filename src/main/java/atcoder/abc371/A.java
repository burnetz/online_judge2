package atcoder.abc371;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sab = sc.next();
        String sac = sc.next();
        String sbc = sc.next();

        if(sab.equals("<")) {
            if(sac.equals("<")) {
                if(sbc.equals("<")) {
                    System.out.println("B");
                }
                else {
                    System.out.println("C");
                }
            }
            else {
                System.out.println("A");
            }
        }
        else {
            if(sac.equals("<")) {
                System.out.println("A");
            }
            else {
                if(sbc.equals("<")) {
                    System.out.println("C");
                }
                else {
                    System.out.println("B");
                }
            }

        }
    }
}