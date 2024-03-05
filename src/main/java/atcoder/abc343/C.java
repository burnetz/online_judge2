package atcoder.abc343;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        String result = "";
        for(long i = 1; i <= 1_000_000 && i * i * i <= n; i++) {
            String nStr = Long.toString(i * i * i);

            String rev = new StringBuffer(nStr).reverse().toString();

            if(nStr.equals(rev)) {
                result = nStr;
            }
        }

        System.out.println(result);

    }
}