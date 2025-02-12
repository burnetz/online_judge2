package atcoder.abc392;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int q[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int index[] = new int[n + 1];
        for(int i = 0; i < n ; i++) {
            index[q[i]] = i;
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(q[p[index[i]] - 1] + " ");
        }
    }
}