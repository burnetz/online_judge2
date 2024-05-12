package atcoder.abc353;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 1; i < n; i++) {
            if(h[i] > h[0]) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(-1);
    }
}