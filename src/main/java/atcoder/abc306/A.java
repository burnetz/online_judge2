package atcoder.abc306;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        for(int i = 0; i < n; i++){
            System.out.print(str.charAt(i) + "" + str.charAt(i));
        }
    }
}
