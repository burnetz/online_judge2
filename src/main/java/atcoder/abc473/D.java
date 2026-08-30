
package atcoder.abc473;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        history = new int[n];
        vectors = new Vector<>();
        sets = new HashSet[n];
        for(int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }

        dfs(0, n, k);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vectors.size(); i++) {
            Vector<Integer> tmpVector = vectors.get(i);
            for(int j = 0; j < tmpVector.size(); j++) {
//                System.out.print(tmpVector.get(j) + " ");
                sb.append(tmpVector.get(j) + " ");
            }
//            System.out.println();
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static int history[];
    static Vector<Vector<Integer>> vectors;
    static Set<Integer>[] sets;

    static boolean dfs(int currentDepth, int maxDepth, int remain) {
        if(currentDepth == maxDepth) {
            if(remain != 0) {
                return false;
            }
            Vector<Integer> tmpVector = new Vector<>();

            for(int i = 0; i < maxDepth; i++) {
                tmpVector.add(history[i]);
            }

            vectors.add(tmpVector);

            return true;
        }

        //階層ごとのNGリストに含まれている場合はスキップ。
        //多くのパターンでこの方法は有効だがN=2のときは全く効かない。
        if(sets[currentDepth].contains(remain)) {
            return false;
        }

        boolean ok = false;
        if(currentDepth < maxDepth - 1) {
            for (int i = 0; i <= 200000; i++) {
                history[currentDepth] = i;
                if (remain >= (currentDepth + 1) * i) {
                    ok |= dfs(currentDepth + 1, maxDepth, remain - (currentDepth + 1) * i);
                } else {
                    break;
                }
            }

            if (!ok) {
                sets[currentDepth].add(remain);
                return false;
            } else {
                return true;
            }
        }
        //ラスト1回はループではなく決め打ちした方が速い。
        //これをやらないとN=2, K=200000などのパターンに対応できない。
        else {
            if (remain % (currentDepth + 1) == 0) {
                history[currentDepth] = remain / (currentDepth + 1);
                dfs(currentDepth + 1, maxDepth, 0);
                return true;
            }
            else {
                return false;
            }
        }

    }
}