package atcoder.abc377;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for(int i = 0; i < 8; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        boolean r[] = new boolean[8];
        boolean c[] = new boolean[8];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(matrix[i][j] == '#') {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        int blankR = 8;
        int blankC = 8;

        for(int i = 0; i < 8; i++) {
            if(r[i]) {
                blankR--;
            }

            if(c[i]) {
                blankC--;
            }
        }

        System.out.println(blankR * blankC);
    }
}