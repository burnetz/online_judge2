package atcoder.abc438;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[] s = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();

        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= n - m; i++) {
            int count = 0;

            for(int j = 0; j < m; j++) {
                if(s[i + j] >= t[j]) {
                    count += s[i + j] - t[j];
                }
                else {
                    count += s[i + j] - t[j] + 10;
                }
            }

            result = Math.min(count, result);
        }

        System.out.println(result);
    }
}