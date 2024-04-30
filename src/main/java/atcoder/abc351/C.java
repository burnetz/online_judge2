package atcoder.abc351;

import java.util.Scanner;
import java.util.Stack;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            while(!stack.isEmpty() && stack.lastElement() == x) {
                stack.pop();
                x++;
            }

            stack.add(x);
        }

        System.out.println(stack.size());

    }
}