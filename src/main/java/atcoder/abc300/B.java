package atcoder.abc300;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] a = new char[h][w];
        char[][] b = new char[h][w];

        for(int i = 0; i < h; i++){
            a[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < h; i++){
            b[i] = sc.next().toCharArray();
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                boolean possible = true;
                for(int k = 0; k < h; k++){
                    for(int l = 0; l < w; l++) {
                        if (a[k][l] != b[(k + i) % h][(l + j)%w]) {
                            possible = false;
                            break;
                        }
                    }
                }
                if(possible){
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
