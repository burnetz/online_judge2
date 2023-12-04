package atcoder.abc331;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int mPerY = sc.nextInt();
        int dPerM = sc.nextInt();

        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        d++;
        if(d > dPerM) {
            d = 1;
            m++;
        }
        if(m > mPerY) {
            m = 1;
            y++;
        }

        System.out.println(y + " " + m + " " + d);
    }
}
