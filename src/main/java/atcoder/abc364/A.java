package atcoder.abc364;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strings = new String[n];

        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        for (int i = 0; i < n - 1; i++) {
            if(strings[i].equals("sweet") && strings[i + 1].equals("sweet") && i < n - 2) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}