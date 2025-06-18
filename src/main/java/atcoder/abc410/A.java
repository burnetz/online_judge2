package atcoder.abc410;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int k = sc.nextInt();

        int count = (int)Arrays.stream(a).filter(e -> e >= k).count();

        System.out.println(count);
    }
}