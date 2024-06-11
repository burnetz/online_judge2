package atcoder.abc357;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int len = (int)Math.pow(3, n);
        matrix = new char[len][len];

        draw(0, 0, n);

        for(int i = 0; i < len; i++) {
            System.out.println(matrix[i]);
        }
    }

    static char[][] matrix;

    static void draw(int x, int y, int level) {
        if(level == 0) {
            matrix[y][x] = '#';
            return;
        }

        int d = (int)Math.pow(3, level - 1);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    for(int k = 0; k < d; k++) {
                        for(int l = 0; l < d; l++) {
                            matrix[i*d + y + k][j*d + x + l]  = '.';
                        }
                    }
                }
                else {
                    draw(i*d + x, j*d + y , level - 1);
                }
            }
        }
    }
}