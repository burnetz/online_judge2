package atcoder.abc341;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).toArray();

        for(int i = 0; i < n - 1; i++) {
            long s = sc.nextLong();
            long t = sc.nextLong();

            a[i + 1] += a[i]/s*t;
        }
        System.out.println(a[n - 1]);
    }
}
