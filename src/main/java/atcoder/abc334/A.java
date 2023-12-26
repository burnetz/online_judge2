package atcoder.abc334;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt();
        int g = sc.nextInt();

        System.out.println(b > g ? "Bat" : "Glove");
    }
}
