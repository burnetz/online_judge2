package atcoder.abc420;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int point[] = new int[n];

        char[][] vote = new char[n][m];
        for(int i = 0; i < n; i++) {
            vote[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < m; i++) {
            int x = 0;
            int y = 0;
            for(int j = 0; j < n; j++) {
                if(vote[j][i] == '0') {
                    x++;
                }
                else {
                    y++;
                }
            }

            if(x == 0 || y == 0) {
                for(int j = 0; j < n; j++) {
                    point[j]++;
                }
            }
            else if (x < y) {
                for(int j = 0; j < n; j++) {
                    if(vote[j][i] == '0') {
                        point[j]++;
                    }
                }
            }
            else {
                for(int j = 0; j < n; j++) {
                    if(vote[j][i] == '1') {
                        point[j]++;
                    }
                }
            }
        }
        int max = Arrays.stream(point).max().getAsInt();

        for(int i = 0; i < n; i++) {
            if(point[i] == max) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}