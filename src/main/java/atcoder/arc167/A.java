package atcoder.arc167;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Arrays.sort(a);

        long result = 0;
        int twoToasts = n - m;
        for(int i = 0; i < twoToasts; i++) {
            result += Math.pow((a[i] + a[2*twoToasts - i - 1]), 2);
        }

        for(int i = 0; i < m - twoToasts ; i++) {
            result += Math.pow(a[n - i - 1], 2);
        }

        System.out.println(result);

    }
}
