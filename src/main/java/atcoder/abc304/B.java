package atcoder.abc304;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int length = str.length();

        if(length <= 3){
            System.out.println(str);
        }
        else {
            System.out.print(str.substring(0, 3));

            for(int i = 0; i < length - 3 ; i++){
                System.out.print(0);
            }
        }
    }
}
