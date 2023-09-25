package atcoder.abc321;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int a[] = new int[n - 1];
        a = Arrays.stream(a).map(e -> sc.nextInt()).toArray();

        int min = Arrays.stream(a).min().getAsInt();
        int max = Arrays.stream(a).max().getAsInt();
        int sum = Arrays.stream(a).sum();

        for(int i = 0; i <= 100; i++) {
            int tmpSum = sum + i - Math.min(i, min) - Math.max(max, i);
            if(tmpSum >= x) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
