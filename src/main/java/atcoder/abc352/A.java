package atcoder.abc352;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        if(x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        if(z > x && z < y) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}