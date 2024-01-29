package atcoder.abc338;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        if(Character.isLowerCase(str.charAt(0))) {
            System.out.println("No");
            return;
        }
        for(int i = 1; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
