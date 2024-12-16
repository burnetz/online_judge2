package atcoder.abc384;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        char str[] = sc.next().toCharArray();

        for(int i = 0; i < n; i++) {
            if(str[i] != c1) {
                str[i] = c2;
            }
        }

        System.out.println(str);
    }
}