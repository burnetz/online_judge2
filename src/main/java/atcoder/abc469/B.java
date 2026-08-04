
package atcoder.abc469;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(str[i] == 'x' && (i == 0 || str[i - 1] == 'x') && (i == n - 1 || str[i + 1] == 'x')) {
                count++;
            }
        }

        System.out.println(count);
    }
}