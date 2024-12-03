package atcoder.abc382;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        String str = sc.next();

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '@') {
                count++;
            }
        }

        System.out.println(n - (count - d));
    }
}