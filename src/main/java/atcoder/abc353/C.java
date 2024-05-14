package atcoder.abc353;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();
        long mod = 100_000_000;

        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(a[i], i);
        }

        long sum[] = new long[n];
        sum[0] = a[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + a[i];
        }

        long result = 0;
        //あらかじめソートしてあるのでa[i]と足してmod以上になるa[j]は後半に固まる。
        //そして問題の制約上1組あたりmodだけ引けば十分。
        for(int i = 0; i < n - 1; i++) {
            int index = Arrays.binarySearch(a, mod - a[i]);
            if(index < 0) {
                index = (index + 1) * (-1);
            }
            //ちょうどmod-a[i]が存在した場合は確実に先頭側にあるものを探す。
            else {
                index = map.get(mod - a[i]);
            }
            index = Math.max(index, i + 1);

            result += (sum[n - 1] - sum[i]) + a[i] * (n - i - 1);
            if(index <= n - 1) {
                result -= (n - index) * mod;
            }

        }

        System.out.println(result);
    }
}