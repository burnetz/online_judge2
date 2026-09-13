
package atcoder.abc475;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        for(int i = 0; i < str.length(); i++) {
            if(i != 0) {
                System.out.print("o");
            }
            System.out.print(str.charAt(i));
        }
        System.out.println();


    }
}