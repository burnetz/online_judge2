package atcoder.abc397;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();

        if(x >= 38) {
            System.out.println(1);
        }
        else if(x >= 37.5){
            System.out.println(2);
        }
        else {
            System.out.println(3);
        }
    }
}