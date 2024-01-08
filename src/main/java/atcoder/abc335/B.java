package atcoder.abc335;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            for(int j = 0; i + j <= n; j++) {
                for(int k = 0; i + j + k <= n; k++) {
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }
}
