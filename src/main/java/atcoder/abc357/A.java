package atcoder.abc357;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            m -= h;

            if(m < 0) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(n);

    }
}