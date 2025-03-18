package atcoder.abc396;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 100; i++) {
            stack.push(0);
        }
        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int x = sc.nextInt();
                    stack.push(x);
                }
                default -> {
                    System.out.println(stack.pop());
                }
            }
        }

    }
}