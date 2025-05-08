package atcoder.abc401;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        if(a >= 200 && a <= 299) {
            System.out.println("Success");
        }
        else {
            System.out.println("Failure");
        }
    }
}