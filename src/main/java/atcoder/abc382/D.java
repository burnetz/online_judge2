package atcoder.abc382;

import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        numbers = new int[n];

        dfs(0, n, m);

        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    static int numbers[];
    static Vector<String> result = new Vector<>();

    static void dfs (int currentDepth, int maxDepth, int maxValue) {
        if(currentDepth == maxDepth) {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i] + " ");
            }

            result.add(sb.toString());

            return;
        }

        int start;
        if(currentDepth == 0) {
            start = 1;
        }
        else {
            start = numbers[currentDepth - 1] + 10;
        }
        //毎回10以上は大きくなるので最終的にMを超えることが途中で明らかになったら打ち止め。
        //これをやらないとTLEになる。
        for(int i = start; i <= maxValue - 10 * (maxDepth - currentDepth - 1); i++) {
            numbers[currentDepth] = i;
            dfs(currentDepth + 1, maxDepth, maxValue);
        }
    }
}