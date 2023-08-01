package atcoder.abc312;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] matrix = new char[n][m];
        for(int i = 0; i < n; i++){
            matrix[i] = sc.next().toCharArray();
        }

        for(int i = 0; i <= n - 9; i++){
loop:            for(int j = 0; j <= m - 9; j++){
                for(int k = i; k < i + 9; k++){
                    for(int l = j; l < j + 9; l++){
                        if(k - i < 3 && l - j < 3 && matrix[k][l] == '.'){
                            continue loop;
                        }
                        if(k - i >= 6 && l - j >= 6 && matrix[k][l] == '.'){
                            continue loop;
                        }
                        if(!(k - i < 3 && l - j < 3) && k - i < 4 && l - j < 4 && matrix[k][l] == '#'){
                            continue loop;
                        }
                        if(!(k - i >= 6 && l - j >= 6) && k - i >=5 && l - j >= 5 && matrix[k][l] == '#'){
                            continue loop;
                        }

                    }
                }

                System.out.println((i + 1) + " " + (j + 1));
            }
        }

    }
}
