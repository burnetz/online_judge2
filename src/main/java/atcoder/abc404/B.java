package atcoder.abc404;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][][] s = new char[4][n][n];
        for(int i = 0; i < n; i++) {
            s[0][i] = sc.next().toCharArray();
        }

        char[][] t = new char[n][n];
        for(int i = 0; i < n; i++) {
            t[i] = sc.next().toCharArray();
        }

        rotate(s[0], s[1]);
        rotate(s[1], s[2]);
        rotate(s[2], s[3]);

        int count[] = new int[4];
        count[1] = 1;
        count[2] = 2;
        count[3] = 3;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    if(t[i][j] != s[k][i][j]) {
                        count[k]++;
                    }
                }
            }
        }

        System.out.println(Arrays.stream(count).min().getAsInt());
    }

    static void rotate(char[][] src, char[][] dst) {
        int n = src.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dst[j][n - i - 1] = src[i][j];
            }
        }
    }
}