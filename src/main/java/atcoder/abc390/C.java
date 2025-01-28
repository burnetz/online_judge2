package atcoder.abc390;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int u = h - 1;
        int b = -1;
        int r = -1;
        int l = w - 1;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#') {
                    u = Math.min(u, i);
                    b = Math.max(b, i);
                    r = Math.max(r, j);
                    l = Math.min(l, j);
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '.' && i >= u && i <= b && j >= l && j <= r) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");

    }
}