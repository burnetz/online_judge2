package atcoder.abc392;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = Arrays.stream(new int[3]).map(e -> sc.nextInt()).sorted().toArray();

        System.out.println(a[0] * a[1] == a[2] ? "Yes" : "No");
    }
}