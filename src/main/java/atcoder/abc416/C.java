package atcoder.abc416;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt() - 1;

        indexes = new int[k];

        String strings[] = new String[n];
        for(int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }

        dfs(0, k, strings);

        Collections.sort(vec);

        System.out.println(vec.get(x));
    }

    static Vector<String> vec = new Vector<>();
    static int indexes[];

    static void dfs(int currentDepth, int maxDepth, String[] strings) {
        if(currentDepth == maxDepth) {
            String result = "";
            for(int i = 0; i < maxDepth; i++) {
                result += strings[indexes[i]];
            }

            vec.add(result);
            return;
        }

        for(int i = 0; i < strings.length; i++) {
            indexes[currentDepth] = i;

            dfs(currentDepth + 1, maxDepth, strings);
        }
    }
}