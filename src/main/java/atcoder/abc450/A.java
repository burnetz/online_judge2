package atcoder.abc450;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = n ; i >= 1; i--) {
            if(i != n) {
                System.out.print(",");
            }
            System.out.print(i);
        }
    }
}