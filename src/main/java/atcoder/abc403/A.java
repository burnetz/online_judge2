package atcoder.abc403;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long sum = 0;

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                sum += sc.nextInt();
            }
            else {
                sc.nextInt();
            }
        }

        System.out.println(sum);
    }
}