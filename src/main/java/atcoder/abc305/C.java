package atcoder.abc305;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int left = w;
        int right = 0;
        int top = 0;
        int bottom = h;

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++){
            matrix[i] = sc.next().toCharArray();

            for(int j = 0; j < w; j++){
                if(matrix[i][j] == '#'){
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.max(top, i);
                    bottom = Math.min(bottom, i);
                }
            }
        }

        for(int i = bottom; i <= top; i++){
            for(int j = left; j <= right; j++){
                if(matrix[i][j] == '.'){
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
}
