package atcoder.abc298;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[][][] = new int[4][n][n];
        int b[][] = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[0][i][j] = sc.nextInt();
                a[1][j][n - i - 1] = a[0][i][j];
                a[2][n - i - 1][n - j - 1] = a[0][i][j];
                a[3][n - j - 1][i] = a[0][i][j];
            }
        }

//        for(int i = 1; i < 4; i++){
//            for(int j = 0; j < n; j++){
//                for(int k = 0; k < n; k++){
//                    System.out.print(a[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                b[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 4; i++){
            boolean ok = true;
            for(int j = 0; j < n && ok; j++){
                for(int k = 0; k < n; k++){
                    if(a[i][j][k] == 1 && b[j][k] == 0){
                        ok = false;
                        break;
                    }
                }
            }

            if(ok){
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}
