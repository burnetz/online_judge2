package atcoder.abc448;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            if(a[i] < x) {
                System.out.println(1);
                x = a[i];
            }
            else {
                System.out.println(0);
            }
        }
    }
}