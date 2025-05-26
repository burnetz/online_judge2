package atcoder.abc405;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int x = sc.nextInt();

        boolean isRated = false;
        switch (x) {
            case 1 -> {
                if(r >= 1600 && r <= 2999) {
                    isRated = true;
                }
            }
            case 2 -> {
                if(r >= 1200 && r <= 2399) {
                    isRated = true;
                }
            }
        }

        System.out.println(isRated ? "Yes" : "No");
    }
}