package atcoder.abc460;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            long x1 = sc.nextInt();
            long y1 = sc.nextInt();
            long r1 = sc.nextInt();
            long x2 = sc.nextInt();
            long y2 = sc.nextInt();
            long r2 = sc.nextInt();

            long dx = x1 - x2;
            long dy = y1 - y2;
            long centerDistSq = dx * dx + dy * dy;

            if(centerDistSq <= (r1 + r2) * (r1 + r2) && centerDistSq >= (r1 - r2) * (r1 - r2)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}