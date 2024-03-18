package atcoder.abc345;

import java.util.Scanner;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(Pattern.matches("<=+>", str) ? "Yes" : "No");

    }
}