package atcoder.abc411;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d[] = Arrays.stream(new int[n - 1]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            int tmpSum = 0;
            for(int j = i + 1; j < n; j++) {
                tmpSum += d[j - 1];
                System.out.print(tmpSum + " ");
            }
            System.out.println();
        }
    }
}