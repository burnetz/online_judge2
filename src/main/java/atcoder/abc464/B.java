
package atcoder.abc464;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int l = w;
        int r = 0;
        int t = h;
        int b = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#') {
                    l = Math.min(l, j);
                    r = Math.max(r, j);
                    t = Math.min(t, i);
                    b = Math.max(b, i);
                }
            }
        }

        for(int i = t; i <= b; i++) {
            for(int j = l; j <= r; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}