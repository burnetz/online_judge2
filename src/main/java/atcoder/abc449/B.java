package atcoder.abc449;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    int tmp = sc.nextInt();
                    System.out.println(tmp * w);
                    h -= tmp;
                }
                case 2 -> {
                    int tmp = sc.nextInt();
                    System.out.println(tmp * h);
                    w -= tmp;
                }
            }
        }
    }
}