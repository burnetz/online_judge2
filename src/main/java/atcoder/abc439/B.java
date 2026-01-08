package atcoder.abc439;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n == 1) {
            System.out.println("Yes");
            return;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(true) {
            int result = calc(n);
            if(set.contains(result)) {
                System.out.println("No");
                return;
            }
            else {
                set.add(result);
            }

            if(result == 1) {
                System.out.println("Yes");
                return;
            }

            n = result;
        }

    }

    static int calc(int n) {
        int result = 0;

        while(n != 0) {
            int digit = n % 10;

            result += digit * digit;

            n /= 10;
        }

        return  result;
    }
}