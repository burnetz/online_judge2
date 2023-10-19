package atcoder.abc323;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        SortedMap<Long, Long> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int amount = sc.nextInt();

            map.put((long)size, (long)amount);
        }

        //基本的には「小さい方から見て合成できるなら合成してしまう」のが最適。
        //この方法で余ったものはどうやっても合成できないため。
        //ただし二匹ずつ合成すると間に合わないので
        //例えば4倍、8倍などのサイズを作れるときはより大きいものを先に作って素材をたくさん消費する。
        //SortedMapを使えば上記を高速に実現できる。
        long result = 0;
        while(!map.isEmpty()) {
            long minKey = map.firstKey();
            long minValue = map.get(minKey);

            int logV = (int)(Math.log(minValue)/Math.log(2));

            for(int i = logV ; i >= 1; i--) {
                long tmp = (long)Math.pow(2, i);
                if(minValue >= tmp) {
                    minValue -= tmp;
                    map.merge(minKey * (long) Math.pow(2, i), 1L, (a, b) -> a + b);
                }
            }
            result += minValue;
            map.remove(minKey);

        }

        System.out.println(result);
    }
}
