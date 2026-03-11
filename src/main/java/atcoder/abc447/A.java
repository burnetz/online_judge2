package atcoder.abc447;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println((n + 1) / 2 >= m ? "Yes" : "No");
    }
}