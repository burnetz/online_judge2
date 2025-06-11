package atcoder.abc409;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int l = 0;
        int r = 1_000_000_001;
        while(r - l > 1) {
            int count = 0;
            int mid = (l + r) / 2;
            for(int i = 0; i < n; i++) {
                if(a[i] >= mid) {
                    count++;
                }
            }

            if(count >= mid) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        System.out.println(l);
    }
}