package atcoder.abc311;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(Math.max(Math.max(str.indexOf('A'), str.indexOf('B')), str.indexOf('C')) + 1);
    }
}
