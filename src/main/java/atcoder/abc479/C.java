
package atcoder.abc479;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        Bentoo[] bentoos = new Bentoo[n];

        for(int i = 0; i < n; i++) {
            bentoos[i] = new Bentoo(sc.nextInt(), sc.nextInt());
        }

        used = new boolean[n];

        dfs(0, n, w, bentoos);

        System.out.println(result);
    }

    static long result = 0;
    static boolean used[];

    static void dfs(int currentDepth, int n, int w, Bentoo[] bentoos) {
        if(currentDepth == n) {
            long tmpSum = 0;
            long tmpWeight = 0;

            for(int i = 0; i < n; i++) {
                if(used[i]) {
                    tmpSum += bentoos[i].taste();
                    tmpWeight += bentoos[i].weight();

                    if(tmpWeight > w) {
                        return;
                    }
                }
            }

            result = Math.max(result, tmpSum);
            return;
        }

        used[currentDepth] = false;
        dfs(currentDepth + 1, n, w, bentoos);
        used[currentDepth] = true;
        dfs(currentDepth + 1, n, w, bentoos);
    }
}

record Bentoo(int taste, int weight) {}