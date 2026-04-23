package atcoder.abc452;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        boolean isOk = false;
        switch (m) {
            case 1 -> {
                if(d == 7) {
                    isOk = true;
                }
            }
            case 3, 5, 7, 9 -> {
                if(m == d) {
                    isOk = true;
                }
            }
        }

        System.out.println(isOk ? "Yes" : "No");
    }
}