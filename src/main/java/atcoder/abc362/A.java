package atcoder.abc362;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        String color = sc.next();
        switch (color) {
            case "Red" -> r = 9999;
            case "Green" -> g = 9999;
            case "Blue" -> b = 9999;
        }

        System.out.println(Math.min(Math.min(r, g), b));

    }
}