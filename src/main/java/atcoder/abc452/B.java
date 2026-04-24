
package atcoder.abc452;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(i == 0 || i == h - 1 || j == 0 || j == w - 1 ? "#" : ".");
            }
            System.out.println();
        }
    }
}