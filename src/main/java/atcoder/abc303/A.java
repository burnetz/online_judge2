package atcoder.abc303;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next().replace("1", "l").replace("0", "o");
        String t = sc.next().replace("1", "l").replace("0", "o");

        if(s.equals(t)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
