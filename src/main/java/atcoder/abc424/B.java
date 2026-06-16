package atcoder.abc424;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int count[] = new int[n];

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            count[a]++;

            if(count[a] == m) {
                System.out.println(a + 1);
            }

        }

    }
}