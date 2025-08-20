package atcoder.abc419;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int rMin = Integer.MAX_VALUE;
        int rMax = Integer.MIN_VALUE;
        int cMin = Integer.MAX_VALUE;
        int cMax = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            rMin = Math.min(rMin, r);
            rMax = Math.max(rMax, r);
            cMin = Math.min(cMin, c);
            cMax = Math.max(cMax, c);
        }

        int rTime = (rMax - rMin + 1) / 2;
        int cTime = (cMax - cMin + 1) / 2;
        System.out.println(Math.max(rTime, cTime));
    }
}