package atcoder.abc343;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        long a[] = new long[n];

        //現在存在する値の登場回数を格納する。
        Map<Long, Integer> map = new HashMap<>();
        //最初は0がn個
        map.put(0L, n);

        for(int i = 0; i < t; i++) {
            int index = sc.nextInt() - 1;
            int point = sc.nextInt();
            long prev = a[index];
            a[index] += point;

            //変更前の値のカウントを1減らす。
            //0になるときはremoveしないと後でsize()が使えない。
            if(map.get(prev) == 1) {
                map.remove(prev);
            }
            else {
                map.merge(prev, 0, (n1, n2) -> n1 - 1);
            }

            //増やすほうはこれだけで十分
            map.merge(a[index], 1, (n1, n2) -> n1 + 1);

            System.out.println(map.size());
        }

    }
}