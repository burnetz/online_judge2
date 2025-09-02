package atcoder.abc421;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int bCount = 0;
        long bDiffSum1 = 0;
        long bDiffSum2 = 0;

        for(int i = 0; i < n * 2; i++) {
            if(s.charAt(i) == 'B') {
                bDiffSum1 += Math.abs(bCount * 2 - i);
                bDiffSum2 += Math.abs(bCount * 2 - i + 1);

                bCount++;
            }
        }

        System.out.println(Math.min(bDiffSum1, bDiffSum2));
    }
}