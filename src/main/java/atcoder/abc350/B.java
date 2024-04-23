package atcoder.abc350;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int t[] = new int[n];
        Arrays.fill(t, 1);

        for(int i = 0; i < q; i++) {
            int index = sc.nextInt() - 1;

            t[index] = (t[index] + 1) % 2;
        }

        System.out.println(Arrays.stream(t).sum());

    }
}