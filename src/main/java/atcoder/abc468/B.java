
package atcoder.abc468;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        String str = sc.next();
        boolean checked[] = new boolean[m];

        for(int i = 0; i < m; i++) {
            if(str.charAt(i) == 'G') {
                for(int j = Math.max(0, i - d) ; j <= Math.min(i + d, m - 1) ; j++) {
                    checked[j] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            if(!checked[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}