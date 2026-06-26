package atcoder.abc454;

import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        String a = sc.next();
        String b = sc.next();

        String str1 = compress(a);
        String str2 = compress(b);

        //各操作は可逆なので、もしstr1をstr2にできるならどちらからでもその中間状態にできるはず。
        //実際にstr1をstr2に一致させる必要はない。
        if(str1.equals(str2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    //(xx)を全てxxに置き換える
    static String compress(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ')') {
                if(stack.size() >= 3) {
                    char c3 = stack.pop();
                    char c2 = stack.pop();
                    char c1 = stack.pop();

                    if(("" + c1 + c2 + c3).equals("(xx")) {
                        stack.push('x');
                        stack.push('x');
                    }
                    else {
                        stack.push(c1);
                        stack.push(c2);
                        stack.push(c3);
                        stack.push(c);
                    }
                }
                else {
                    stack.push(c);
                }
            }
            else {
                stack.push(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}