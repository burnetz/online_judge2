package atcoder.abc392;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count[] = new int[1001];

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            count[sc.nextInt()]++;
        }

        System.out.println(n - m);
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}