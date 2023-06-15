package atcoder.abc298;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int ok = 0;
        int ng = 0;

        for (int i = 0; i < n; i++){
            char tmpC = str.charAt(i);

            if(tmpC == 'o'){
                ok++;
            }
            else if(tmpC == 'x'){
                ng++;
            }
        }

        if(ok >= 1 && ng == 0){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
