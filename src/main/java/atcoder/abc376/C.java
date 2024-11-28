package atcoder.abc376;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();
        int b[] = Arrays.stream(new int[n - 1]).map(e -> sc.nextInt()).sorted().toArray();

        int result = -1;
        int current = n - 2;
        for(int i = n - 1; i >= 0; i--) {
            if(current >= 0 && a[i] <= b[current]) {
                current--;
            }
            else {
                if(result < 0) {
                    result = a[i];
                }
                else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);

    }
}