package atcoder.arc177;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c1 = sc.nextInt();
        int c5 = sc.nextInt();
        int c10 = sc.nextInt();
        int c50 = sc.nextInt();
        int c100 = sc.nextInt();
        int c500 = sc.nextInt();
        int n = sc.nextInt();
        int x[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            while (c500 > 0 && x[i] >= 500) {
                x[i] -= 500;
                c500--;
            }
            while (c100 > 0 && x[i] >= 100) {
                x[i] -= 100;
                c100--;
            }
            while (c50 > 0 && x[i] >= 50) {
                x[i] -= 50;
                c50--;
            }
            while (c10 > 0 && x[i] >= 10) {
                x[i] -= 10;
                c10--;
            }
            while (c5 > 0 && x[i] >= 5) {
                x[i] -= 5;
                c5--;
            }
            while (c1 > 0 && x[i] >= 1) {
                x[i] -= 1;
                c1--;
            }

            if(x[i] > 0) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
