package atcoder.abc345;

import java.util.Scanner;
import java.util.regex.Pattern;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        if(n % 10 == 0) {
            System.out.println(n / 10);
        }
        else {
            if(n > 0) {
                System.out.println(n / 10 + 1);
            }
            else {
                System.out.println(n / 10);
            }
        }
    }
}