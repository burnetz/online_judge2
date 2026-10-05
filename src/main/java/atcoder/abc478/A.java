
package atcoder.abc478;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            if(i < m % n) {
                System.out.println(m / n + 1);
            }
            else {
                System.out.println(m / n);
            }
        }
    }
}