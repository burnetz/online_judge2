package atcoder.abc367;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        r = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        nums = new int[n];

        dfs(0, n, k);

        System.out.print(sb);
    }

    static int[] r;
    static int[] nums;
    static StringBuffer sb = new StringBuffer();

    static void dfs(int currentDepth, int maxDepth, int k) {
        if(currentDepth == maxDepth) {
            int sum = Arrays.stream(nums).sum();

            if(sum % k == 0) {
                Arrays.stream(nums).forEach(e -> sb.append(e + " "));
                sb.append("\n");
            }
            return;
        }

        for(int i = 1; i <= r[currentDepth]; i++) {
            nums[currentDepth] = i;
            dfs(currentDepth + 1, maxDepth, k);
        }
    }
}