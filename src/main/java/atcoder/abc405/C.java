package atcoder.abc405;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        long arraySum = Arrays.stream(a).sum();
        long tmpSum = 0;
        long result = 0;

        for(int i = 0; i < n; i++) {
            tmpSum += a[i];
            result += a[i] * (arraySum - tmpSum);
        }

        System.out.println(result);
    }
}