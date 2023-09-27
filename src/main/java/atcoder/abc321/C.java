package atcoder.abc321;

import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //条件を満たす数字は10!よりも遥かに少ない（減少列だから）のですべて試しても十分間に合う。
        for(int i = 1; i <= 10; i++) {
            dfs(0, i, n, 0, 9);
        }

    }

    static long count = -1;

    static void dfs(int currentDepth, int maxDepth, int target, long currentNum, int endDigit) {
        if(currentDepth == maxDepth) {
            count++;

            if(count == target) {
                System.out.println(currentNum);
                System.exit(0);
            }
            return;
        }
        for(int i = 0; i <= endDigit ; i++) {
            dfs(currentDepth + 1, maxDepth, target, currentNum * 10 + i, i - 1);
        }
    }
}
