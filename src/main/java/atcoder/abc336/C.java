package atcoder.abc336;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1;

        if(n == 0) {
            System.out.println(0);
            return;
        }
        String result = "";

        while(n != 0) {
            result = n % 5 * 2 + result;
            n /= 5;
        }

        System.out.println(result);

    }
}
