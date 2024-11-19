package atcoder.abc378;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count[] = new int[5];
        for(int i = 0; i < 4; i++) {
            int num = sc.nextInt();

            count[num]++;
        }

        int result = 0;
        for(int i = 1; i <= 4; i++) {
            result += count[i] / 2;
        }

        System.out.println(result);
    }
}