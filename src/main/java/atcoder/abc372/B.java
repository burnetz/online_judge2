package atcoder.abc372;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long m = sc.nextLong();

        dfs(0, 20, m, 0);

    }

    static int power[] = new int[20];

    static void dfs(int currentDepth, int maxDepth, long m, long currentSum) {
        if(currentSum == m) {
            System.out.println(currentDepth);
            for(int i = 0; i < currentDepth; i++) {
                System.out.print(power[i] + " ");
            }
            System.exit(0);
        }

        if(currentDepth == maxDepth) {
            return;
        }

        for(int i = 10; i >= 0; i--) {
            long tmp = (long)Math.pow(3, i);

            if(currentSum + tmp <= m) {
                power[currentDepth] = i;
                dfs(currentDepth + 1, maxDepth, m, currentSum + tmp);
            }
        }
    }
}