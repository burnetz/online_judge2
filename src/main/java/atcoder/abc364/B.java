package atcoder.abc364;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int startRow = sc.nextInt() - 1;
        int startCol = sc.nextInt() - 1;

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        String command = sc.next();

        int currentRow = startRow;
        int currentCol = startCol;
        for(int i = 0; i < command.length(); i++) {
            char dir = command.charAt(i);

            int tmpRow = currentRow;
            int tmpCol = currentCol;
            switch (dir) {
                case 'U' -> {
                    tmpRow--;
                }
                case 'D' -> {
                    tmpRow++;
                }
                case 'L' -> {
                    tmpCol--;
                }
                case 'R' -> {
                    tmpCol++;
                }
            }
            if(tmpRow >= 0 && tmpRow < h && tmpCol >= 0 && tmpCol < w && matrix[tmpRow][tmpCol] == '.') {
                currentRow = tmpRow;
                currentCol = tmpCol;
            }
        }

        System.out.println((currentRow + 1) + " " + (currentCol + 1));
    }
}