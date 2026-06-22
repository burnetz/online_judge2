package atcoder.abc463;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Taka[] takas = new Taka[n];

        for(int i = 0; i < n; i++) {
            takas[i] = new Taka(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(takas, Comparator.comparingDouble(Taka::leaveTime));

        int dp[] = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max((int)takas[i].height(), dp[i + 1]);
        }

        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int t = sc.nextInt();

            int index = Arrays.binarySearch(takas, new Taka(0, t + 0.5), Comparator.comparingDouble(Taka::leaveTime));
            index++;
            index *= -1;

            System.out.println(dp[index]);
        }
    }
}

record Taka(int height, double leaveTime) {}