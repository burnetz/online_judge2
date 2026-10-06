
package atcoder.abc478;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //各クエリについて始点と終点（半開区間）をタイムラインとして管理できるようにする。
        Vector<Integer>[] addEvents = new Vector[n + 1];
        Vector<Integer>[] deleteEvents = new Vector[n + 1];
        for(int i = 0; i <= n; i++) {
            addEvents[i] = new Vector<>();
            deleteEvents[i] = new Vector<>();
        }
        for(int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt();
            int value = sc.nextInt();

            addEvents[l].add(value);
            deleteEvents[r].add(value);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            //追加イベントよりも削除イベントの方が先でないとおそらく答えが変わる。
            for(int j = 0; j < deleteEvents[i].size(); j++) {
                int tmp = deleteEvents[i].get(j);

                if(map.get(tmp) > 1) {
                    map.put(tmp, map.get(tmp) - 1);
                }
                else {
                    map.remove(tmp);
                }
            }

            for(int j = 0; j < addEvents[i].size(); j++) {
                int tmp = addEvents[i].get(j);

                map.merge(tmp, 1, (e1, e2) -> e1 + 1);
            }
            System.out.print(map.size() + " ");

        }
    }
}