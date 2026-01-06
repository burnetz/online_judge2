package atcoder.abc434;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count[] = new int[m];
        int sum[] = new int[m];

        for(int i = 0; i < n; i++) {
            int type = sc.nextInt() - 1;
            int weight = sc.nextInt();

            sum[type] += weight;
            count[type]++;
        }

        for(int i = 0; i < m; i++) {
            System.out.println((double) sum[i] / count[i]);
        }
    }
}