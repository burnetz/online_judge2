package atcoder.abc354;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long h = sc.nextInt();

        long d = 1;
        long l = 0;
        for(int i = 1; ; i++) {
            l += d;
            if(l > h) {
                System.out.println(i);
                return;
            }
            d *= 2;
        }


    }
}