package atcoder.abc355;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = (int)Math.pow(2, sc.nextInt());
        int b = (int)Math.pow(2, sc.nextInt());

        if((a^b) != 0) {
            System.out.println((int)(Math.log10(14 - (a^b))/Math.log10(2)));
        }
        else {
            System.out.println(-1);
        }
    }
}