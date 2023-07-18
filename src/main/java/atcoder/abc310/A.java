package atcoder.abc310;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, sc.nextInt());
        }

        System.out.println(Math.min(p, q + min));
    }
}
