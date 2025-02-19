package atcoder.abc375;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] originalMatrix = new char[n][n];
        for(int i = 0; i < n; i++) {
            originalMatrix[i] = sc.next().toCharArray();
        }

        char[][] resultMatrix = new char[n][n];

        //外周から内周へと描画した際に、周回数を4で割った余りによって何度回転させるかが決まる。
        //毎回該当の正方形内の全ピクセルの回転をシミュレートする必要は無い。
        for(int i = 0; i < n / 2; i++) {
            //上辺
            for(int j = i; j < n - i; j++) {
                resultMatrix[i][j] = pick(originalMatrix, j, i, n, i % 4);
            }
            //左端と右端
            for(int j = i + 1; j < n - i - 1; j++) {
                resultMatrix[j][i] = pick(originalMatrix, i, j, n, i % 4);
                resultMatrix[j][n - 1 - i] = pick(originalMatrix, n - 1 - i, j, n, i % 4);
            }
            //底辺
            for(int j = i; j < n - i; j++) {
                resultMatrix[n - 1 - i][j] = pick(originalMatrix, j, n - 1 - i, n, i % 4);

            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(resultMatrix[i]);
        }
    }

    static char pick(char matrix[][], int x, int y, int n, int mode) {
        switch (mode) {
            case 0 -> {
                return matrix[n - x - 1][y];
            }
            case 1 -> {
                return matrix[n - y - 1][n - x - 1];
            }
            case 2 -> {
                return matrix[x][n - y - 1];
            }
            default -> {
                return matrix[y][x];
            }
        }
    }
}