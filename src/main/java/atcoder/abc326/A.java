package atcoder.abc326;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        if(y >= x - 3 && y <= x + 2) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
