package atcoder.abc389;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();

        long tmp = 1;
        for(int i = 1; ; i++) {
            tmp *= i;

            if(tmp == x) {
                System.out.println(i);
                break;
            }
        }
    }
}