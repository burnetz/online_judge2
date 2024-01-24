package atcoder.abc337;

import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int result = Integer.MAX_VALUE;
        //行について求める
        for (int i = 0; i < h; i++) {
            //区間内の.とxの個数を計算できるようにする
            int dots[] = new int[w + 1];
            int xs[] = new int[w + 1];

            for (int j = 0; j < w; j++) {
                dots[j + 1] = dots[j] + (matrix[i][j] == '.' ? 1 : 0);
                xs[j + 1] = xs[j] + (matrix[i][j] == 'x' ? 1 : 0);
            }

            for(int j = 0; j + k <= w; j++) {
                //区間内にxがある場合はスキップ
                if(xs[j + k] - xs[j] > 0) {
                    continue;
                }

                result = Math.min(result, dots[j + k] - dots[j]);
            }
        }

        //列について求める
        for (int i = 0; i < w; i++) {
            int dots[] = new int[h + 1];
            int xs[] = new int[h + 1];

            for (int j = 0; j < h; j++) {
                dots[j + 1] = dots[j] + (matrix[j][i] == '.' ? 1 : 0);
                xs[j + 1] = xs[j] + (matrix[j][i] == 'x' ? 1 : 0);
            }

            for(int j = 0; j + k <= h; j++) {
                if(xs[j + k] - xs[j] > 0) {
                    continue;
                }

                result = Math.min(result, dots[j + k] - dots[j]);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

}
