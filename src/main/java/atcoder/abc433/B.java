package atcoder.abc433;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

loop:        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(a[j] > a[i]) {
                    System.out.println(j + 1);
                    continue loop;
                }
            }

            System.out.println(-1);
        }
    }
}