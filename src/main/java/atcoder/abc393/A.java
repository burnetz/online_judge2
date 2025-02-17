package atcoder.abc393;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isSickT = sc.next().equals("sick");
        boolean isSickA = sc.next().equals("sick");

        int result = 1;
        if(!isSickT && !isSickA) {
            result = 4;
        }
        else if(!isSickT && isSickA) {
            result = 3;
        }
        else if(isSickT && !isSickA) {
            result = 2;
        }

        System.out.println(result);
    }
}