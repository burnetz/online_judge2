package atcoder.abc394;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('>', '<');
        map.put(']', '[');
        map.put('(', 'X');
        map.put('<', 'X');
        map.put('[', 'X');

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        System.out.println(stack.isEmpty() ? "Yes" : "No");
    }
}