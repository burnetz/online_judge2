
package atcoder.abc473;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        //map<S, T> : a[]の総和をKで割った余りがSになったときのインデックスTを保存する。
        //同一キーについて随時アップデートされる。
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int dp[] = new int[n + 1];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
            int key = (int)(sum % k);

            if(map.containsKey(key)) {
                dp[i + 1] = dp[map.get(key) + 1] + 1;
            }
            //a[i]から部分列を作らない方が良いパターンもあるのでmax()を取る。
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            map.put(key, i);

        }

        System.out.println(Arrays.stream(dp).max().getAsInt());


    }
}