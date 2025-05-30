package atcoder.abc407;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            int digit = s.charAt(s.length() - 1 - i) - '0';

            int tmp = digit - result % 10;

            if(tmp < 0) {
                tmp += 10;
            }

            result += tmp;
        }

        result += s.length();

        System.out.println(result);

    }
}