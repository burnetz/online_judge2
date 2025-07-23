package atcoder.abc415;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        int m = sc.nextInt();

        Exchange[] exchanges = new Exchange[m];

        for(int i = 0; i < m; i++) {
            exchanges[i] = new Exchange(sc.nextLong(), sc.nextLong());
        }

        //1回の交換で瓶の数が減らない方が有利なので（交換前）-（交換後）の値でソートする。
        Arrays.sort(exchanges, Comparator.comparingLong(Exchange::gap));

        long result = 0;

        //より有利な方法で交換できるだけ交換する。
        for(int i = 0; i < m; i++) {
            long times = Math.max(0, (n - exchanges[i].after)) / exchanges[i].gap();

            result += times;
            n -= times * exchanges[i].gap();
        }

        System.out.println(result);
    }
}

class Exchange {
    long before;
    long after;

    Exchange(long before, long after) {
        this.before = before;
        this.after = after;
    }

    long gap() {
        return this.before - this.after;
    }
}