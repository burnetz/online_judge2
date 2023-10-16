package atcoder.abc323;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        for(int i = 1; i < 16; i += 2) {
            if(str[i] != '0') {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
