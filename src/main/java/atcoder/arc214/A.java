package atcoder.arc214;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        char[][] result = new char[n][n];

        //右上がりの斜線上の数字が全て同じであれば条件を満たす。
loop1:  for(int i = 0; i < n * 2 - 1; i++) {
loop2:      for(char j = '0'; j <= '9' ; j++) {
                int limit = Math.min(i, n - 1);
                for(int k = 0; k <= limit; k++) {
                    int r = i - k;
                    int c = k;

                    if(r >= n) {
                        continue ;
                    }

                    if (matrix[r][c] == '?') {
                        result[r][c] = j;
                    } else {
                        if (matrix[r][c] != j) {
                            continue loop2;
                        } else {
                            result[r][c] = j;
                        }
                    }

                    if(k == limit) {
                        continue loop1;
                    }
                }

            }
            System.out.println(-1);
            return;

        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }
}
