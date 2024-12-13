package atcoder.abc375;

import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = str.length();

        //あらかじめi文字目までのある文字のインデックスの和と登場回数をメモしておくと
        //後で高速に計算できる。
        long[][] indexSum = new long[n + 1][26];
        int[][] count = new int[n + 1][26];

        for(int i = 0; i < n; i++) {
            int cIndex = str.charAt(i) - 'A';

            for(int j = 0; j < 26; j++) {
                if(j == cIndex) {
                    indexSum[i + 1][j] = indexSum[i][j] + i;
                    count[i + 1][j] = count[i][j] + 1;
                }
                else {
                    indexSum[i + 1][j] = indexSum[i][j];
                    count[i + 1][j] = count[i][j];
                }
            }
        }

        long result = 0;
        for(int i = 0; i < n - 2; i++) {
            int cIndex = str.charAt(i) - 'A';

            int tmpCount = count[n][cIndex] - count[i + 2][cIndex];

            long tmp = indexSum[n][cIndex] - indexSum[i + 2][cIndex] - (long)tmpCount * (i + 1);

            result += tmp;

        }

        System.out.println(result);

    }
}
