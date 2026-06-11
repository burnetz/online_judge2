package atcoder.abc457;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong() - 1;

        int[][] matrix = new int[n][];
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            matrix[i] = Arrays.stream(new int[l]).map(e -> sc.nextInt()).toArray();
        }

        long c[] = Arrays.stream(new long[n]).map(e -> sc.nextInt()).toArray();
//        long cSum = Arrays.stream(c).sum();

        for(int i = 0; i < n; i++) {
            if(k >= c[i] * matrix[i].length) {
                k -= c[i] * matrix[i].length;
                continue;
            }

            k %= matrix[i].length;

            System.out.println(matrix[i][(int)k]);
            return;
        }
    }
}