package atcoder.abc387;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int sum = 0;

        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(i * j != x) {
                    sum += i * j;
                }
            }
        }

        System.out.println(sum);
    }
}