package atcoder.abc305;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n % 5 == 0){
            System.out.println(n);
            return;
        }

        for(int i = 1; i <= 4 ; i++){
            if((n + i) % 5 == 0){
                System.out.println(n + i);
                return;
            }
            if((n - i) % 5 == 0){
                System.out.println(n - i);
                return;
            }
        }
    }
}
