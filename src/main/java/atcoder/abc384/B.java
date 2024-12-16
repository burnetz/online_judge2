package atcoder.abc384;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int div = sc.nextInt();

            int top = 0;
            int bottom = 0;
            switch (div) {
                case 1 -> {
                    bottom = 1600;
                    top = 2799;
                }
                case 2 -> {
                    bottom = 1200;
                    top = 2399;
                }
            }

            int a = sc.nextInt();

            if(r >= bottom && r <= top) {
                r += a;
            }

//            System.out.println(r);
        }
        System.out.println(r);
    }
}