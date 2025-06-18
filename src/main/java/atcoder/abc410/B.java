package atcoder.abc410;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int q = sc.nextInt();

        int a[] = new int[n];
        int log[] = new int[q];

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                int minIndex = 0;
                for(int j = 1; j < n; j++) {
                    if(a[minIndex] > a[j]) {
                        minIndex = j;
                    }
                }

                a[minIndex]++;
                log[i] = minIndex + 1;
            }
            else {
                a[x - 1]++;
                log[i] = x;
            }
        }

        Arrays.stream(log).forEach(System.out::println);
    }
}