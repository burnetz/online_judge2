package atcoder.abc327;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        for(int i = 1; ; i++) {
            long tmp = 1;

            for(int j = 1; j <= i; j++) {
                tmp *= i;
                if (tmp == n) {
                    System.out.println(i);
                    return;
                } else if (tmp > n) {
                    System.out.println(-1);
                    return;
                }
            }
        }
    }
}
