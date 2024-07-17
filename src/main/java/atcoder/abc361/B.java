package atcoder.abc361;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x[] = Arrays.stream(new int[12]).map(e -> sc.nextInt()).toArray();

        if(intersect(x[0], x[3], x[6], x[9]) && intersect(x[1], x[4], x[7], x[10]) && intersect(x[2], x[5], x[8], x[11])) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    static boolean intersect(int a1, int a2, int b1, int b2) {
        return Math.min(a2, b2) - Math.max(a1, b1) > 0;
    }
}