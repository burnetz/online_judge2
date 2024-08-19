package atcoder.abc367;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean awake[] = new boolean[24];
        Arrays.fill(awake, true);

        for(int i = b; i % 24 != c ; i++) {
            i %= 24;
            awake[i] = false;
        }

        System.out.println(awake[a] ? "Yes" : "No");

    }
}