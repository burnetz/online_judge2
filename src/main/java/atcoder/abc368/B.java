package atcoder.abc368;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        int count = 0;
        while(a[n - 2] > 0) {
            a[n - 1]--;
            a[n - 2]--;
            Arrays.sort(a);
            count++;
        }

        System.out.println(count);
    }
}