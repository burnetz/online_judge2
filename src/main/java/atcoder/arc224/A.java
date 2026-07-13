package atcoder.arc224;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        long k = sc.nextInt();
        for(int i = 1; i <= 100; i++) {
            long tmp = k * i;

            String str = Long.toString(tmp);

            if(str.matches("\\d*00\\d*")) {
                System.out.println(tmp);
                return;
            }
        }


    }
}