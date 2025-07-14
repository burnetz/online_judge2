package atcoder.abc414;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        long n = sc.nextLong();

        long result = 0;

        for(int i = 0; i <= 9999999 ; i++) {
            String leftString = Integer.toString(i);
            String rightString = new StringBuffer(leftString).reverse().toString();

            long num1 = Long.parseLong(leftString + rightString);

            if(leftString.equals("0")) {
                leftString = "";
                rightString = "";
            }

            if(num1 > n) {
                break;
            }
            String num1String = Long.toString(num1, a);

            if(isPalindo(num1String)) {
                result += num1;
            }

            for(int j = 0; j <= 9; j++) {
                long num2 = Long.parseLong(leftString + j + rightString);

                if(num2 > n) {
                    break;
                }
                String num2String = Long.toString(num2, a);

                if(isPalindo(num2String)) {
                    result += num2;
                }
            }
        }

        System.out.println(result);


    }

    static boolean isPalindo(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}