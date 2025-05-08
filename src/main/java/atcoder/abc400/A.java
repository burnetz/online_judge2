package atcoder.abc400;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        if(400 % a != 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(400 / a);
        }
    }
}