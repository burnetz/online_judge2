package atcoder.abc455;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                for(int k = i; k < h; k++) {
                    for(int l = j ; l < w; l++) {
                        boolean isOk = true;
                        for(int m = 0; m < (k - i + 1); m++) {
                            for(int n = 0; n < (l - j + 1); n++) {
                                if(matrix[i + m][j + n] != matrix[k - m][l - n]) {
                                    isOk = false;
                                    break;
                                }
                            }
                            if(!isOk) {
                                break;
                            }
                        }

                        if(isOk) {
//                            System.out.println(i + " " + j + " " + k + " " + l);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}