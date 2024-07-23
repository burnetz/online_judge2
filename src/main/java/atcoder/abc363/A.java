package atcoder.abc363;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        int r2 = (r/100 + 1)*100;

        System.out.println(r2 - r);
    }
}