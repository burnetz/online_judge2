package atcoder.abc312;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String list[] = {"ACE", "BDF", "CEG", "DFA", "EGB", "FAC", "GBD"};
        String str = sc.next();

        if(Arrays.stream(list).anyMatch(str::equals)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
