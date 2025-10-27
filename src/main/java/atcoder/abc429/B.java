package atcoder.abc429;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int sum = Arrays.stream(a).sum();

        for(int i = 0; i < n; i++) {
            if(sum - a[i] == m) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
}