package atcoder.abc313;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(0);
            return;
        }
        int p0 = sc.nextInt();
        int p[] = new int[n - 1];

        Arrays.setAll(p, a -> sc.nextInt());

        int maxVal = Arrays.stream(p).max().getAsInt();
        System.out.println(p0 > maxVal ? 0 : maxVal + 1 - p0);
    }
}
