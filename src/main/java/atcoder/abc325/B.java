package atcoder.abc325;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum[] = new long[24];
        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int x = sc.nextInt();

            for(int j = 9; j < 18; j++) {
                sum[(j + x) % 24] += w;
            }
        }

        System.out.println(Arrays.stream(sum).max().getAsLong());
    }
}
