package atcoder.abc399;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a[] = Arrays.stream(new int[2*n]).map(e -> sc.nextInt()).toArray();

            long result = solve(a);

            System.out.println(result);
        }
    }

    static long solve(int a[]) {
        int n = a.length;

        //NGリストのようなもの
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n - 1; i++) {
            if(a[i] == a[i + 1]) {
                set.add(a[i]);
            }
        }
        //NGリストにない数字が隣り合っているならインデックスを保存する。
        //同じキーについて2回登場するなら後の方に更新する。
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n - 1; i++) {
            if(set.contains(a[i])) {
                continue;
            }

            map.put(generateKey(a[i], a[i + 1]), i);
        }

        long result = 0;
        for(int i = 0; i < n - 1; i++) {
            String key = generateKey(a[i], a[i + 1]);

            int tmpIndex = -1;
            if(map.containsKey(key)) {
                tmpIndex = map.get(key);
            }

            //同じキーが2以上離れた箇所に登場していれば条件を満たす。
            //逆に1しか離れていない場合は場所が被っているので誤認識。
            if(tmpIndex - i >= 2) {
                result++;
            }
        }

        return result;
    }

    //キーは小さい数字が先になるように作る。
    static String generateKey(int n1, int n2) {
        String tmpS;

        if(n1 < n2) {
            tmpS = n1 + "," + n2;
        }
        else {
            tmpS = n2 + "," + n1;
        }

        return tmpS;
    }
}