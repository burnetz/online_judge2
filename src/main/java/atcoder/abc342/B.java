package atcoder.abc342;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int pos[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            pos[sc.nextInt() - 1] = i;
        }

        int q = sc.nextInt();

        for(int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            if(pos[a] < pos[b]) {
                System.out.println(a + 1);
            }
            else {
                System.out.println(b + 1);
            }
        }
    }
}