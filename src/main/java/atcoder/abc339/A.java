package atcoder.abc339;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] strArray = str.split("\\.");
        System.out.println(strArray[strArray.length - 1]);
    }
}
