package atcoder.abc446;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        int result = 0;
        //現時点で各数字を末尾に持つ数列の最大の長さを保存する。
        //配列で作るとメモリが足りないのでmapを使う。
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            //既にある数列の末尾に連結できる場合
            if(map.containsKey(a[i] - 1)) {
                int tmp = map.get(a[i] - 1);
                map.merge(a[i], tmp + 1, (e1, e2) -> Math.max(tmp + 1, e1));
            }
            //a[i]が起点となる場合
            else {
                map.merge(a[i], 1, (e1, e2) -> Math.max(1, e1));
            }

            result = Math.max(map.get(a[i]), result);
        }

        System.out.println(result);
    }
}