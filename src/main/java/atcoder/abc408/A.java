package atcoder.abc408;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int wakeUntil = s;
        int currentTime = 0;

        for(int i = 0; i < n; i++) {
            currentTime = sc.nextInt();

            if(currentTime > wakeUntil) {
                System.out.println("No");
                return;
            }

            wakeUntil = currentTime + s;

        }

        System.out.println("Yes");

    }
}