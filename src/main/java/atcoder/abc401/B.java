package atcoder.abc401;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean isLogin = false;
        int count = 0;

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            switch (s) {
                case "login" -> {isLogin = true;}
                case "logout" -> {isLogin = false;}
                case "private" -> {
                    if(!isLogin) {
                        count++;
                    }
                }
                case "public" -> {}
            }
        }

        System.out.println(count);
    }
}