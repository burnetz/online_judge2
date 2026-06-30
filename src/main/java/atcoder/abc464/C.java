
package atcoder.abc464;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        //Dとしてあり得る値がそこまで大きくないので全て保存した上で時系列順に処理できる。
        Vector<Event>[] vectors = new Vector[m + 1];
        for(int i = 0; i <= m; i++) {
            vectors[i] = new Vector<>();
        }

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            int b = sc.nextInt();

            map.merge(a, 1, (n1, n2) -> n1 + 1);
            vectors[d].add(new Event(a, b));
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < vectors[i].size(); j++) {
                Event event = vectors[i].elementAt(j);

                if(map.get(event.a()) == 1) {
                    map.remove(event.a());
                }
                else {
                    map.merge(event.a(), 0, (n1, n2) -> n1 - 1);
                }

                map.merge(event.b(), 1, (n1, n2) -> n1 + 1);
            }


            System.out.println(map.size());
        }

    }
}

record Event (int a, int b) {}