
package atcoder.abc482;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = new char[5][5];
        for(int i = 0; i < 5; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int result = 5;
        for(int i = 0; i < 5; i++) {
            int tmp = 0;
            for(int j = 0; j < 5; j++) {
                if(matrix[i][j] == 'o') {
                    tmp++;
                }
            }

            result = Math.min(result, 5 - tmp);
        }

        for(int i = 0; i < 5; i++) {
            int tmp = 0;
            for(int j = 0; j < 5; j++) {
                if(matrix[j][i] == 'o') {
                    tmp++;
                }
            }

            result = Math.min(result, 5 - tmp);
        }

        int tmp = 0;
        for(int i = 0; i < 5; i++) {
            if (matrix[i][i] == 'o') {
                tmp++;
            }
        }
        result = Math.min(result, 5 - tmp);

        tmp = 0;
        for(int i = 0; i < 5; i++) {
            if (matrix[i][4 - i] == 'o') {
                tmp++;
            }
        }
        result = Math.min(result, 5 - tmp);

        System.out.println(result);
    }
}