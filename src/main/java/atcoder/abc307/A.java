package atcoder.abc307;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int sum = 0;

            for(int j = 0; j < 7; j++){
                sum += sc.nextInt();
            }

            System.out.print(sum + " ");
        }
    }
}
