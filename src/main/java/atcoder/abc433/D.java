package atcoder.abc433;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = Arrays.stream(new int[n]).map(e->sc.nextInt()).toArray();
        Map<Integer, Integer>[] maps = new Map[12];
        for(int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }

        //各A_iに10^jを掛けたときのmodの値をjごとに区別してカウントする。
        for(int i = 0; i < n; i++) {
            int key = a[i] % m;
            for(int j = 0; j < maps.length; j++) {
                maps[j].merge(key, 1, (e1, e2) -> e1 + 1);

                key = (int)((long)key * 10 % m);
            }
        }

        long result = 0;
        for(int i = 0; i < n; i++) {
            //a[i]の桁数確認
            int power10 = 0;
            int tmp = a[i];
            while(tmp > 0) {
                power10++;
                tmp /= 10;
            }

            int remain = (m - (a[i] % m)) % m;

            if(maps[power10].containsKey(remain)) {
                int count = maps[power10].get(remain);

                result += count;
            }
        }

        System.out.println(result);
    }
}