package atcoder.abc327;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String str = sc.next();

        System.out.println(str.contains("ab") || str.contains("ba") ? "Yes" : "No");
    }
}
