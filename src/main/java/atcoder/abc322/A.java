package atcoder.abc322;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String str = sc.next();
        if(str.contains("ABC")) {
            System.out.println(str.indexOf("ABC") + 1);
        }
        else {
            System.out.println(-1);
        }

    }
}
