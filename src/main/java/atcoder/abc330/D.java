package atcoder.abc330;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] matrix = new char[n][n];

        for(int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        long count = 0;
        //各行・列に含まれるoの数をメモする。
        int row[] = new int[n];
        int col[] = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 'o') {
                    row[j]++;
                    col[i]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 'o') {
                    //(j, i)のoも当然含まれているので1を引く
                    count += (col[i] - 1) * (row[j] - 1);
                }
            }
        }

        System.out.println(count);
    }
}
