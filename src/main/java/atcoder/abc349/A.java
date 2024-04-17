package atcoder.abc349;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = Arrays.stream(new int[n - 1]).map(e -> sc.nextInt()).sum();

        System.out.println(-sum);

    }
}