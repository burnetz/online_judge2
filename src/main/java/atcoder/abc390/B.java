package atcoder.abc390;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n - 2; i++) {
            if(a[i + 1] * a[i + 1] != a[i] * a[i + 2]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}