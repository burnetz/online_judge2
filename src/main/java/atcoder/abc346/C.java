package atcoder.abc346;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();

        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextInt()).sorted().toArray();

        long aSum = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] > k || (i > 0 && a[i] == a[i - 1])) {
                continue;
            }
            aSum += a[i];
        }

        System.out.println(k*(k + 1)/2 - aSum);
    }
}