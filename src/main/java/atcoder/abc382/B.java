package atcoder.abc382;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();

        for(int i = 0; i < d; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (chars[j] == '@') {
                    chars[j] = '.';
                    break;
                }
            }
        }

        System.out.println(chars);
    }
}