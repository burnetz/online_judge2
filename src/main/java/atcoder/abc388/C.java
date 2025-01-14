package atcoder.abc388;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double a[] = Arrays.stream(new double[n]).map(e -> sc.nextDouble()).toArray();

        long result = 0;
        for(int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(a, a[i] * 2 - 0.5);

            index++;
            index *= -1;

            result += n - index;
        }

        System.out.println(result);
    }
}