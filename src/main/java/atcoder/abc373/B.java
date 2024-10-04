package atcoder.abc373;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String keys = sc.next();

        int result = 0;
        for(int i = 0; i < 25; i++) {
            char from = (char)('A' + i);
            char to = (char)('A' + i + 1);

            int fromIndex = keys.indexOf(from);
            int toIndex = keys.indexOf(to);

            result += Math.abs(fromIndex - toIndex);
        }

        System.out.println(result);
    }
}