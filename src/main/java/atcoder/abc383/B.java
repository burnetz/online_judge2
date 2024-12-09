package atcoder.abc383;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int d = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int result = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#') {
                    continue;
                }
                for(int k = 0; k < h; k++) {
                    for(int l = 0; l < w; l++) {
                        if(matrix[k][l] == '#') {
                            continue;
                        }
                        int tmpCount = 0;
                        for(int p = 0; p < h; p++) {
                            for(int q = 0; q < w; q++) {
                                if(matrix[p][q] == '#') {
                                    continue;
                                }
                                if (dist(i, j, p, q) <= d || dist(k, l, p, q) <= d) {
                                    tmpCount++;
//                                    System.out.printf("%d %d %d\n", p, q, tmpCount);

                                }
                            }
                        }

//                        System.out.printf("complete %d %d %d %d %d\n", i, j, k, l, tmpCount);

                        result = Math.max(result, tmpCount);
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}