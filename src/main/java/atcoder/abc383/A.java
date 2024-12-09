package atcoder.abc383;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int current = 0;
        int prevT = 0;

        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int v = sc.nextInt();

            current = Math.max(0, current - (t - prevT)) + v;
            prevT = t;

//            System.out.println(current);
        }

        System.out.println(current);
    }
}