package atcoder.abc324;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        while(n % 2 == 0) {
            n /= 2;
        }

        while(n % 3 == 0) {
            n /= 3;
        }

        System.out.println(n == 1 ? "Yes" : "No");
    }
}
