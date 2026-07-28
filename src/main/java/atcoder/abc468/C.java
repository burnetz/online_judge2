
package atcoder.abc468;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int p[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();
        int q[] = Arrays.stream(new int[n]).map(e -> sc.nextInt() - 1).toArray();

        digits = new int[n];
        used = new boolean[n];

        StringBuilder pStrBuilder = new StringBuilder();
        StringBuilder qStrBuilder = new StringBuilder();

        for(int i = 0; i < n; i++) {
            pStrBuilder.append(p[i]);
            qStrBuilder.append(q[i]);
        }
        String pStr = pStrBuilder.toString();
        String qStr = qStrBuilder.toString();

        dfs(0, n);

        int indexP = 0;
        int indexQ = 0;
        for(int i = 0; i < vec.size(); i++) {
            if(vec.get(i).equals(pStr)) {
                indexP = i;
            }
            if(vec.get(i).equals(qStr)) {
                indexQ = i;
            }
        }

        System.out.println(Math.max(0, indexQ - indexP - 1));
    }

    static Vector<String> vec = new Vector<>();
    static int[] digits;
    static boolean[] used;
    static void dfs(int currentDepth, int maxDepth) {
        if(currentDepth == maxDepth) {
            StringBuilder tmpStr = new StringBuilder();

            for(int i = 0; i < maxDepth; i++) {
                tmpStr.append(digits[i]);
            }
            vec.add(tmpStr.toString());
        }

        for(int i = 0; i < maxDepth; i++) {
            if(!used[i]) {
                used[i] = true;
                digits[currentDepth] = i;
                dfs(currentDepth + 1, maxDepth);
                used[i] = false;
            }
        }
    }
}