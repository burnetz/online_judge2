package atcoder.abc376;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int currentTime;
        int lastTime = -100000;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();

            currentTime = t;
            if(currentTime >= lastTime + c) {
//                System.out.println("get " + i);
                count++;
                lastTime = currentTime;
            }
        }

        System.out.println(count);
    }
}