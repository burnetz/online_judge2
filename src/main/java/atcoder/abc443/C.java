package atcoder.abc443;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int result = 0;
        int recentlyOpen = 0;

        for(int i = 0; i < n; i++) {
            int time = sc.nextInt();

            if(time >= recentlyOpen) {
                result += time - recentlyOpen;
                recentlyOpen = time + 100;
            }
        }

        result += Math.max(0, t - recentlyOpen);

        System.out.println(result);

    }
}