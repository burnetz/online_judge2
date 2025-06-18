package atcoder.abc410;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        int head = 0;

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    int p = sc.nextInt() - 1;
                    int x = sc.nextInt();

                    a[(head + p) % n] = x;
                }
                case 2 -> {
                    int p = sc.nextInt() - 1;

                    System.out.println(a[(head + p) % n]);
                }
                case 3 -> {
                    int k = sc.nextInt();

                    head = (head + k) % n;
                }
            }
        }

//        Arrays.stream(a).forEach(System.out::println);
    }
}