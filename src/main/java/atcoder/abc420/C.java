package atcoder.abc420;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int b[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.min(a[i], b[i]);
        }

        for(int i = 0; i < q; i++) {
            String query = sc.next();
            int index = sc.nextInt() - 1;
            int value = sc.nextInt();

            switch (query) {
                case "A" -> {
                    int before = Math.min(a[index], b[index]);
                    int after = Math.min(value, b[index]);

                    a[index] = value;
                    sum = sum - before + after;
                }
                case "B" -> {
                    int before = Math.min(a[index], b[index]);
                    int after = Math.min(a[index], value);

                    b[index] = value;
                    sum = sum - before + after;
                }
            }

            System.out.println(sum);
        }
    }
}