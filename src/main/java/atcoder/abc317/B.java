package atcoder.abc317;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n ; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i = 0; i < n; i++) {
            if(i >= 1 && a[i - 1] + 1 != a[i]) {
                System.out.println(a[i - 1] + 1);
                return;
            }
        }
    }
}
