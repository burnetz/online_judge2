package atcoder.abc339;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        int dx[] = {0, 1, 0, w - 1};
        int dy[] = {h - 1, 0, 1, 0};

        int currentX = 0;
        int currentY = 0;
        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            Arrays.fill(matrix[i], '.');
        }

        int dir = 0;
        for(int i = 0; i < n; i++) {
            if(matrix[currentY][currentX] == '.') {
                matrix[currentY][currentX] = '#';
                dir = (dir + 1) % 4;
            }
            else {
                matrix[currentY][currentX] = '.';
                dir = (dir + 3) % 4;
            }

            currentX = (currentX + dx[dir]) % w;
            currentY = (currentY + dy[dir]) % h;

        }

        Arrays.stream(matrix).forEach(System.out::println);
    }
}
