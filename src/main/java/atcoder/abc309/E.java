package atcoder.abc309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        edges = new ArrayList[n];
        applied = new boolean[n];

        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i < n ; i++) {
            int tmp = sc.nextInt() - 1;

            edges[tmp].add(i);
        }

        generation = new int[n];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();

            generation[a] = Math.max(generation[a], b);
        }

        dfs(0, generation[0]);

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(applied[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    static ArrayList<Integer>[] edges;
    static boolean[] applied;
    static int[] generation;

    static void dfs(int target, int remainGeneration) {
        //本人が保険に入っているか祖先の保険の効力が残っているなら保険適用
        if(generation[target] > 0 || remainGeneration > 0) {
            applied[target] = true;
        }

       for(int i = 0; i < edges[target].size() ; i++) {
            int next = edges[target].get(i);
            //祖先の保険の残りと自分の保険のうち効果が大きい方を子に適用させる
            dfs(next, Math.max(remainGeneration - 1, generation[target]));
        }
    }
}
