package atcoder.abc328;

import java.util.*;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Deque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A' -> {
                    stack.add("A");
                }
                case 'B' -> {
                    if(!stack.isEmpty() && stack.getLast().equals("A")) {
                        stack.removeLast();
                        stack.add("AB");
                    }
                    //こちらの分岐のBは半端になるが出力のために必要。
                    else {
                        stack.add("B");
                    }
                }
                case 'C' -> {
                    //ABCを作れたならスタックから削除する。
                    if(!stack.isEmpty() && stack.getLast().equals("AB")) {
                        stack.removeLast();
                    }
                    //こちらのCは半端になるが出力に必要。
                    else {
                        stack.add("C");
                    }
                }
            }
        }

        stack.stream().forEach(System.out::print);
    }
}