package atcoder.abc453;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int x = sc.nextInt();

        int a[] = Arrays.stream(new int[t + 1]).map(e -> sc.nextInt()).toArray();

        System.out.println(0 + " " + a[0]);
        int value = a[0];

        for(int i = 1; i < t + 1; i++) {
            if(Math.abs(a[i] - value) >= x) {
                value = a[i];
                System.out.println(i + " " + value);
            }
        }
    }
}