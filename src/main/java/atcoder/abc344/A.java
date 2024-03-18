package atcoder.abc344;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] strArray = sc.next().split("\\|", -1);

        System.out.println(strArray[0] + strArray[2]);

    }
}