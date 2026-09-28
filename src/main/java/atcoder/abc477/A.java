
package atcoder.abc477;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String result;

        switch (str) {
            case "B" -> result = "Y";
            case "Y" -> result = "R";
            default -> result = "B";
        }

        System.out.println(result);


    }
}