package atcoder.abc318;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(n >= m ? (n - m) / p + 1 : 0
        );

    }
}
