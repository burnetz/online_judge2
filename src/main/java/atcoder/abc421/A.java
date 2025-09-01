package atcoder.abc421;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String name[] = new String[n];

        for(int i = 0; i < n; i++) {
            name[i] = sc.next();
        }

        int x = sc.nextInt() - 1;
        String y = sc.next();

        System.out.println(y.equals(name[x]) ? "Yes" : "No");
    }
}