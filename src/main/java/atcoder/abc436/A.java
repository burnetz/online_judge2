package atcoder.abc436;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder s = new StringBuilder(sc.next());

        while(s.length() < n) {
            s.insert(0, 'o');
        }

        System.out.println(s);
    }
}