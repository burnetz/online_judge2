package atcoder.abc385;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        String command = sc.next();

        boolean[][] visited = new boolean[h][w];
        visited[r][c] = true;

        for(int i = 0; i < command.length(); i++) {
            char dir = command.charAt(i);

            int tmpR = r;
            int tmpC = c;

            switch (dir) {
                case 'U' -> {
                    tmpR--;
                }
                case 'D' -> {
                    tmpR++;
                }
                case 'L' -> {
                    tmpC--;
                }
                case 'R' -> {
                    tmpC++;
                }
            }

            if(tmpC >= 0 && tmpC < w && tmpR >= 0 && tmpR < h && matrix[tmpR][tmpC] != '#') {
                visited[tmpR][tmpC] = true;
                r = tmpR;
                c = tmpC;
            }
        }

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(visited[i][j] && matrix[i][j] == '@') {
                    count++;
                }
            }
        }

        System.out.println((r + 1) + " " + (c + 1) + " " + count);
    }
}