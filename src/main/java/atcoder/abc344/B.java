package atcoder.abc344;

import java.util.Scanner;
import java.util.Stack;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        while(sc.hasNextInt()) {
            stack.push(sc.nextInt());
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}