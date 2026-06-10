package atcoder.abc459;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n ; i++) {
            String str = sc.next();
            int tmp = 0;
            switch (str.charAt(0)) {
                case 'a','b','c' -> {
                    tmp = 2;
                }
                case 'd','e','f' -> {
                    tmp = 3;
                }
                case 'g','h','i' -> {
                    tmp = 4;
                }
                case 'j','k','l' -> {
                    tmp = 5;
                }
                case 'm','n','o' -> {
                    tmp = 6;
                }
                case 'p','q','r','s' -> {
                    tmp = 7;
                }
                case 't','u','v' -> {
                    tmp = 8;
                }
                case 'w','x','y','z' -> {
                    tmp = 9;
                }
            }
            System.out.print(tmp);
        }

    }
}