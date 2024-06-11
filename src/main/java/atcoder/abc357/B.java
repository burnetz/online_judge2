package atcoder.abc357;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int upper = 0;
        int lower = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(Character.isUpperCase(c)) {
                upper++;
            }
            else {
                lower++;
            }
        }

        if(upper > lower) {
            System.out.println(str.toUpperCase());
        }
        else {
            System.out.println(str.toLowerCase());
        }
    }
}