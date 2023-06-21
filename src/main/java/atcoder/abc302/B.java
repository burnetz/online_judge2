package atcoder.abc302;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];

        for(int i = 0; i < h; i++){
            matrix[i] = sc.next().toCharArray();
        }

        int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
        char[] snuke = "snuke".toCharArray();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                boolean isSnuke = false;

                for(int k = 0; k < 8; k++){
                    for(int l = 0; l < 5; l++) {
//                        System.out.println("l = "+ l);
                        int tmpX = j + dx[k]*l;
                        int tmpY = i + dy[k]*l;

                        if (tmpX < 0 || tmpX >= w || tmpY < 0 || tmpY >= h || matrix[tmpY][tmpX] != snuke[l]) {
                            break;
                        }

                        if (l == 4) {
                            isSnuke = true;
                            break;
                        }
                    }

                    if(isSnuke){
                        for(int l = 0; l < 5; l++){
                            int tmpX = j + dx[k]*l + 1;
                            int tmpY = i + dy[k]*l + 1;

                            System.out.println(tmpY + " " + tmpX);
                        }
                        return;
                    }
                }
            }
        }
    }
}
