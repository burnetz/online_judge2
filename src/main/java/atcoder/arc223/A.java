package atcoder.arc223;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        long w = sc.nextLong();

        weight = new long[n];
        value = new long[n];

        for(int i = 0; i < n; i++) {
            weight[i] = sc.nextLong();
            value[i] = sc.nextLong();
        }

        weightSum = new long[n];
        weightSum[0] = weight[0];
        valueSum = new long[n];
        valueSum[0] = value[0];
        for(int i = 1; i < n; i++) {
            weightSum[i] = weight[i] + weightSum[i - 1];
            valueSum[i] = value[i] + valueSum[i - 1];
        }

        long result = dfs(n - 1, w);

        System.out.println(result);

    }

    static long weight[];
    static long value[];
    static long weightSum[];
    static long valueSum[];

    static long dfs(int currentDepth, long remainWeight) {
        if(currentDepth == 0) {
            if(remainWeight >= weight[0]) {
                return value[0];
            }
            else {
                return 0;
            }
        }

        //残りの荷物を全て選ぶことができる状況なら再帰する必要がない。
        //今回の問題はこの分岐を入れることで高速に処理できる。
        if(remainWeight >= weightSum[currentDepth]) {
            return valueSum[currentDepth];
        }

        //着目している荷物を選ばない場合
        long result1 = dfs(currentDepth - 1, remainWeight);
        long result2 = 0;
        //着目している荷物を選ぶ場合
        if(remainWeight >= weight[currentDepth]) {
            result2 = dfs(currentDepth - 1, remainWeight - weight[currentDepth]) + value[currentDepth];
        }

        return Math.max(result1, result2);
    }
}