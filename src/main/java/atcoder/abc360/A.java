package atcoder.abc360;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if(str.matches(".*R[A-Z]*M.*")) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}