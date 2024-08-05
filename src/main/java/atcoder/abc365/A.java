package atcoder.abc365;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 365;
        if(n % 400 == 0) {
            result = 366;
        }
        else if(n % 100 == 0) {
            result = 365;
        }
        else if(n % 4 == 0) {
            result = 366;
        }

        System.out.println(result);
    }
}