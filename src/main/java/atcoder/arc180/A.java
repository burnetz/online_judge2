package atcoder.arc180;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        str += str.charAt(str.length() - 1);
        int mod = 1_000_000_000 + 7;

        long result = 1;
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) != str.charAt(i + 1)) {
                count++;
            }
            else {
                if(count >= 3) {
                    result = result * ((count + 1) / 2) % mod;
                }
                count = 1;
            }
        }

        System.out.println(result);
    }
}
