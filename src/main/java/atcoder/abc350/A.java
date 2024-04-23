package atcoder.abc350;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next().substring(3));

        if(n > 0 && n < 350 && n != 316) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}