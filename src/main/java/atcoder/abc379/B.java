package atcoder.abc379;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        String str = sc.next();

        int result = 0;
        int current = 0;
        for(int i = 0; i < n; i++) {
            char c = str.charAt(i);

            if(c == 'O') {
                current++;

                if(current == k) {
                    result++;
                    current = 0;
                }
            }
            else {
                current = 0;
            }
        }

        System.out.println(result);

    }
}