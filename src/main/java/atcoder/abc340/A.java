package atcoder.abc340;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        for(int i = a; i <= b; i += d) {
            System.out.print(i + " ");
        }
    }
}
