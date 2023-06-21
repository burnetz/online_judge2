package atcoder.abc300;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < n; i++) {
            if(a + b == sc.nextInt()) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}