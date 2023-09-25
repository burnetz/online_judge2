package atcoder.abc321;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        for(int i = 0; i < str.length - 1; i++) {
            if(str[i] <= str[i + 1]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
}
