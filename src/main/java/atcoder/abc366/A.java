package atcoder.abc366;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();

        if(t > n / 2 || a > n / 2) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}