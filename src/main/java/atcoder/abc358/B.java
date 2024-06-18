package atcoder.abc358;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int last = 0;
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();

            last = Math.max(last + a, t + a);
            System.out.println(last);
        }
    }
}