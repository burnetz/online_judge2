package atcoder.abc337;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(str.matches("A*B*C*") ? "Yes" : "No");
    }
}
