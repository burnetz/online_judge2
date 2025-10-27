package atcoder.abc429;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int count[] = new int[n + 1];

        long result = 0;
        long sumOfPairs = 0;
        for(int i = 0; i < n; i++) {
            int same = count[a[i]];
            int diff = i - same;

            result += (long)same * diff;
            result += sumOfPairs - (long)count[a[i]] * (count[a[i]] - 1) / 2;

            sumOfPairs -= (long)count[a[i]] * (count[a[i]] - 1) / 2;
            count[a[i]]++;
            sumOfPairs += (long)count[a[i]] * (count[a[i]] - 1) / 2;

        }

        System.out.println(result);
    }
}