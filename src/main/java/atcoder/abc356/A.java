package atcoder.abc356;

import java.util.Scanner;

public class A {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        for(int i = 1; i < l; i++) {
            System.out.print(i + " ");
        }
        for(int i = r; i >= l; i--) {
            System.out.print(i + " ");
        }
        for(int i = r + 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }
}