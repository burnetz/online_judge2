package atcoder.abc367;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String x = sc.next();

        if(x.contains(".")) {
            while(x.charAt(x.length() - 1) == '0') {
                x = x.substring(0, x.length() - 1);
            }

            if(x.charAt(x.length() - 1) == '.') {
                x = x.substring(0, x.length() - 1);
            }
            System.out.println(x);
        }
        else {
            System.out.println(x);
        }
    }
}