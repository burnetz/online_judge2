package atcoder.abc369;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[n] = Integer.MAX_VALUE;

        long result = n + n - 1;
loop:        for(int i = 0; i < n - 2; i++) {
            if(a[i + 2] - a[i + 1] == a[i + 1] - a[i]) {
                int d = a[i + 1] - a[i];
                int len = 3;
                for(int j = i + 3; j < n ; j++) {
                    if(a[j] - a[j - 1] != d) {
                        break;
                    }
                    len++;
                }

//                System.out.println("array from " + i + " to " + (i + len));
                result += (long)(len - 1)*(len - 2) / 2;
                i += len - 2;
            }
        }

        System.out.println(result);
    }
}