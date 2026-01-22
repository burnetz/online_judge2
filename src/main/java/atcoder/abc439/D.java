package atcoder.abc439;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.merge(a[i], 1, (e1, e2) -> e1 + 1);
        }

        long result = 0;
        Map<Integer, Integer> mapPartial = new HashMap<>();
        for(int i = 0; i < n; i++) {
            //ある5の倍数の前と後ろのそれぞれについて条件を満たす数字の個数を求める。
            if(a[i] % 5 == 0) {
                int times = a[i] / 5;

                int tmpFull3 = 0;
                int tmpFull7 = 0;
                if(map.containsKey(times * 3)) {
                    tmpFull3 = map.get(times * 3);
                }

                if(map.containsKey(times * 7)) {
                    tmpFull7 = map.get(times * 7);
                }

                int tmpPartial3 = 0;
                int tmpPartial7 = 0;
                if(mapPartial.containsKey(times * 3)) {
                    tmpPartial3 = mapPartial.get(times * 3);
                }

                if(mapPartial.containsKey(times * 7)) {
                    tmpPartial7 = mapPartial.get(times * 7);
                }

                result += (long) tmpPartial3 * tmpPartial7;

                result += (long) (tmpFull3 - tmpPartial3) * (tmpFull7 - tmpPartial7);
            }

            mapPartial.merge(a[i], 1, (e1, e2) -> e1 + 1);
        }

        System.out.println(result);
    }
}