package atcoder.abc415;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int x = sc.nextInt();

        if (Arrays.stream(a).anyMatch(e -> e == x)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}