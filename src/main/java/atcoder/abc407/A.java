package atcoder.abc407;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        double aByB = (double)a/b;
        double floorAB = Math.floor(aByB);
        double ceilAB = Math.ceil(aByB);

        if(aByB - floorAB < ceilAB - aByB) {
            System.out.println((int)floorAB);
        }
        else {
            System.out.println((int)ceilAB);
        }

    }
}