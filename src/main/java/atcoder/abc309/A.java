package atcoder.abc309;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;

        if(a / 3 == b / 3 && b % 3 - a % 3 == 1) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
