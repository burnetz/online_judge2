
package atcoder.abc477;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        //マスごとにタイル関連の操作のタイミングを記録する。なお降順
        PriorityQueue<Integer>[] queues = new PriorityQueue[n];
        for(int i = 0; i < n; i++) {
            queues[i] = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        }

        //色関連の操作のタイミングと色を記録する。
        TreeMap<Integer, String> colorLog = new TreeMap<>();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();
            switch (mode) {
                case 1 -> {
                    int x = sc.nextInt() - 1;
                    queues[x].add(i);

                }
                case 2 -> {
                    String s = sc.next();

                    colorLog.put(i, s);

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            //そのマスが覆われていないとき。ダミーとして全クエリの後に覆われたことにするとやりやすい。
            if(queues[i].size() % 2 == 0) {
                queues[i].add(q);
            }

            //-1の時点でタイルが除かれたことにするとやりやすい。こちらは最終的な状態にかかわらずダミーを追加する。
            queues[i].add(-1);
            boolean done = false;
            //「タイルを除く→タイルを置く」のペアの間で行われた塗装を取得する。
            //除去と配置が間髪入れずに行われた場合は次のペアについて同様に調べる。
            while (!queues[i].isEmpty()) {
                int a = queues[i].poll();
                int b = queues[i].poll();

                if(a - b > 1) {
                    Integer tmpKey = colorLog.lowerKey(a);
                    if(tmpKey != null && tmpKey > b) {
                        done = true;
                        sb.append(colorLog.get(tmpKey));
                        break;
                    }
                }
            }
            if(!done) {
                sb.append("a");
            }

        }

        System.out.println(sb);

    }
}