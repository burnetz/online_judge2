package atcoder.abc408;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean appear[] = new boolean[101];

        int count = 0;
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(!appear[tmp]) {
                appear[tmp] = true;
                count++;
            }
        }

        System.out.println(count);
        for(int i = 0; i < appear.length; i++) {
            if(appear[i]) {
                System.out.print(i + " ");
            }
        }
    }
}