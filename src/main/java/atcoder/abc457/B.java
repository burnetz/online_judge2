package atcoder.abc457;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][];
        for(int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int tmp[] = Arrays.stream(new int[l]).map(e -> sc.nextInt()).toArray();

            matrix[i] = tmp;
        }

        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        System.out.println(matrix[x][y]);
    }
}