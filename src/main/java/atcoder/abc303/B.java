package atcoder.abc303;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[][] = new int[m][n];
        boolean maybeFriends[][] = new boolean[n][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
                if(j >= 1){
                    int id1 = a[i][j - 1] - 1;
                    int id2 = a[i][j] - 1;
                    maybeFriends[id1][id2] = true;
                    maybeFriends[id2][id1] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(!maybeFriends[i][j]){
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
