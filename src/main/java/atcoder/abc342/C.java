package atcoder.abc342;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        int q = sc.nextInt();

        //各アルファベットが最終的に何に変換されるかを管理する
        Stack<String> stacks[] = new Stack[26];
        for(int i = 0; i < 26; i++) {
            stacks[i] = new Stack<>();
            stacks[i].add((char)('a' + i) + "");
        }
        for(int i = 0; i < q; i++) {
            String from = sc.next();
            String to = sc.next();

            for(int j = 0; j < 26; j++) {
                //元々の文字ではなく直近の変換後の文字について判断する。
                if(stacks[j].lastElement().equals(from)) {
                    stacks[j].push(to);
                }
            }

        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length; i++) {
            sb.append(stacks[str[i] - 'a'].lastElement());
        }
        System.out.println(sb);
    }
}