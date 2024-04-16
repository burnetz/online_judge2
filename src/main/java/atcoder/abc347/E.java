
package atcoder.abc347;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //それぞれの数字に発生するイベントのタイミングを記録する。
        //必ず追加と削除のペアになるようにする。
        Vector<Integer>[] events = new Vector[n + 1];
        for(int i = 0; i <= n; i++) {
            events[i] = new Vector<>();
        }

        //その時点での要素数について累積和を記録する。
        long sumLog[] = new long[q + 1];
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= q; i++) {
            int x = sc.nextInt();

            if(set.contains(x)) {
                set.remove(x);
            }
            else {
                set.add(x);
            }
            events[x].add(i);

            sumLog[i] = sumLog[i - 1] + set.size();
        }

        for(int i = 1; i <= n; i++) {
            //最後まで残った数字についてはクエリ終了後に削除があったものとする。
            if(events[i].size() % 2 == 1) {
                events[i].add(q + 1);
            }
            long result = 0;
            //その数字がセット内にあったときに加算される値は累積和から出せる。
            for(int j = 0; j < events[i].size(); j += 2) {
                result += sumLog[events[i].get(j + 1) - 1] - sumLog[events[i].get(j) - 1];
            }

            System.out.print(result + " ");
        }
    }
}