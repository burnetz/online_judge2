package atcoder.abc335;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        matrix[n/2][n/2] = n*n;

        int vx[] = {1, 0, -1, 0};
        int vy[] = {0, 1, 0, -1};

        int currentX = -1;
        int currentY = 0;
        int dir = 0;
        int currentNum = 1;

        //渦巻状に埋めていけば必ずできる
        while(currentNum < n * n) {
            int tmpX = currentX + vx[dir];
            int tmpY = currentY + vy[dir];

            if(inRange(tmpX, tmpY, n) && matrix[tmpY][tmpX] == 0) {
                currentX = tmpX;
                currentY = tmpY;
                matrix[currentY][currentX] = currentNum;
                currentNum++;
            }
            else {
                dir = (dir + 1) % 4;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == n*n) {
                    System.out.print("T ");
                }
                else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    static boolean inRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
