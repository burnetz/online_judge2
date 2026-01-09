package atcoder.abc435;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int current = a[0] - 1;
        int count = 1;

        for(int i = 1; i < n && current > 0; i++) {
            count++;

            current = Math.max(current - 1, a[i] - 1);
        }

        System.out.println(count);
    }
}