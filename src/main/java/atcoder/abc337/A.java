package atcoder.abc337;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sumA = 0;
        int sumB = 0;

        for(int i = 0; i < n; i++) {
            sumA += sc.nextInt();
            sumB += sc.nextInt();
        }

        if(sumA > sumB) {
            System.out.println("Takahashi");
        }
        else if (sumA < sumB) {
            System.out.println("Aoki");
        }
        else {
            System.out.println("Draw");
        }
    }
}
