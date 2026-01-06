package atcoder.abc432;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = Arrays.stream(new int[3]).map(e -> sc.nextInt()).sorted().toArray();

        System.out.println(calc(a[2], a[1], a[0]));
    }

    static int calc(int a, int b, int c) {
        return a * 100 + b * 10 + c;
    }
}