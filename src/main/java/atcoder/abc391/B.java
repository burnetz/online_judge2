package atcoder.abc391;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char matrix1[][] = new char[n][n];
        char matrix2[][] = new char[m][m];

        for(int i = 0; i < n; i++) {
            matrix1[i] = sc.next().toCharArray();
        }
        for(int i = 0; i < m; i++) {
            matrix2[i] = sc.next().toCharArray();
        }

        for(int a = 0; a <= n - m; a++) {
            for(int b = 0; b <= n - m; b++) {

                boolean ok = true;
                for(int i = 0; i < m; i++) {
                    for(int j = 0; j < m; j++) {
                        if(matrix1[i + a][j + b] != matrix2[i][j]) {
                            ok = false;
                            break;
                        }
                    }
                }

                if(ok) {
                    System.out.println((a + 1) + " " + (b + 1));
                    return;
                }
            }
        }

    }
}