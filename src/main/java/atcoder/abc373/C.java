package atcoder.abc373;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();
        int b[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        System.out.println(a[n - 1] + b[n - 1]);
    }
}