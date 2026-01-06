package atcoder.abc434;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((int)Math.ceil((double)(w * 1000 + 1) / b));
    }
}