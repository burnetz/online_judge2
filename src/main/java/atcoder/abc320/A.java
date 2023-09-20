package atcoder.abc320;

import java.util.HashMap;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((long)(Math.pow(a, b) + Math.pow(b, a)));

    }
}
