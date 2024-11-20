package atcoder.abc378;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int q[] = new int[n];
        int r[] = new int[n];

        for(int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        int question = sc.nextInt();

        for(int i = 0; i < question; i++) {
            int type = sc.nextInt() - 1;
            int d = sc.nextInt();

            int tmpMod = d % q[type];

            if(tmpMod == r[type]) {
                System.out.println(d);
            }
            else if(tmpMod < r[type]) {
                System.out.println(d + (r[type] - tmpMod));
            }
            else {
                System.out.println(d + q[type] - (tmpMod - r[type]));
            }
        }

    }
}