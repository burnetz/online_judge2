package atcoder.abc375;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int count = 0;
        for(int i = 0; i < n - 2; i++) {
            if(str.charAt(i) == '#' && str.charAt(i + 1) == '.' && str.charAt(i + 2) == '#') {
                count++;
            }
        }

        System.out.println(count);
    }
}