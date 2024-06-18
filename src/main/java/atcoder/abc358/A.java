package atcoder.abc358;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(s.equals("AtCoder") && t.equals("Land") ? "Yes" : "No");
    }
}