package atcoder.abc441;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int q = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(inRange(p, q, 100, 100, x, y) ? "Yes" : "No");

    }

    static boolean inRange(int p, int q, int h, int w, int x, int y) {
        return x >= p && x < p + h && y >= q && y < q + w;
    }
}