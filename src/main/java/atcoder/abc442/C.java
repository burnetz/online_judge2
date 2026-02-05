package atcoder.abc442;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] relations = new int[n];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            relations[a]++;
            relations[b]++;
        }

        for(int i = 0; i < n; i++) {
            int tmp = n - relations[i] - 1;
            long result = (long)tmp * (tmp - 1) * (tmp - 2) / 6;

            System.out.println(result);
        }

    }
}