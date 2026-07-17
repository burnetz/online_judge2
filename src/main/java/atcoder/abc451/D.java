package atcoder.abc451;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        powers = new Vector[11];
        for(int i = 0; i < powers.length; i++) {
            powers[i] = new Vector<>();
        }

        for(int i = 0; ; i++) {
            int tmp = (int)Math.pow(2, i);
            if(tmp > 1_000_000_000) {
                break;
            }

            String str = Integer.toString(tmp);
            powers[str.length()].add(tmp);
        }

        //nの値にかかわらず登場しうる整数を全て生成するため必ず1秒くらいかかる。
        dfs(0, 9);

        Collections.sort(result);

        System.out.println(result.get(n - 1));
    }

    //2のべき乗を桁数ごとに管理すると使いやすくなる。
    static Vector<Integer>[] powers;
    //setを使って既に登場した整数を記憶する
    static Set<Integer> set = new HashSet();
    static Vector<Integer> result = new Vector<>();

    //枝刈り等を適切におこなっていれば10^9以下で該当する整数を全て生成することが可能
    static void dfs(int currentNumber, int maxDepth) {
        //枝刈り用
        if(set.contains(currentNumber)) {
            return;
        }

        int currentDepth = 0;

        //0も長さで言えば1桁ということになるが例外として取り扱う
        if(currentNumber != 0) {
            set.add(currentNumber);
            result.add(currentNumber);
            String currentNumStr = Integer.toString(currentNumber);
            currentDepth = currentNumStr.length();

            if (currentDepth == maxDepth) {
                return;
            }
        }

        for(int i = 1; i <= maxDepth - currentDepth; i++) {
            for(int j = 0; j < powers[i].size(); j++) {
                dfs(currentNumber * (int)Math.pow(10, i) + powers[i].get(j), maxDepth);
            }
        }
    }
}