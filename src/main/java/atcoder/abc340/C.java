package atcoder.abc340;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        map.put(1L, 0L);

        System.out.println(calc(n));
    }
    static Map<Long, Long> map = new HashMap<>();

    //メモ化再帰で十分高速に解くことができる
    static long calc (long num) {
        if(map.containsKey(num)) {
            return map.get(num);
        }
        long cost = num;

        long num1 = num/2;
        long num2 = (num + 1)/2;

        cost += calc(num1) + calc(num2);

        map.put(num, cost);

        return cost;

    }
}
