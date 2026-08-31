
package atcoder.abc469;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        WinCount[] winCounts = new WinCount[n];
        for(int i = 0; i < n; i++) {
            winCounts[i] = new WinCount(i);
        }

        int a[] = new int[m];
        int b[] = new int[m];
        for(int i = 0; i < m; i++) {
            int tmpA = sc.nextInt() - 1;
            int tmpB = sc.nextInt() - 1;

            a[i] = tmpA;
            b[i] = tmpB;

            winCounts[tmpA].count++;
            winCounts[tmpB].count++;
        }

        Arrays.sort(winCounts, (e1, e2) -> Integer.compare(e2.count, e1.count));

        //全ての決勝に同一の選手が勝ち進んだ場合は計算が変わるので特別扱い。
        if(winCounts[0].count == m) {
            //全ての試合を同一の2人が占めている場合
            if(winCounts[1].count == m) {
                System.out.println(2*(n - 1) - 1);
            }
            else {
                System.out.println(n - 1);
            }
            return;
        }

        Set<String> result = new HashSet<>();
        //あるプレイヤーから見て、自分がいない試合の全てに勝ち進んだプレイヤーの数を数える。
        //普通にやるとO(MN)になるが、上位4プレイヤーだけに着目すれば良い。
        for(int i = 0; i < Math.min(n, 4); i++) {

            int remain = m - winCounts[i].count;

            int tmpCount[] = new int[n];
            for(int j = 0; j < m; j++) {
                if(a[j] == winCounts[i].id || b[j] == winCounts[i].id) {
                    continue;
                }

                tmpCount[a[j]]++;
                tmpCount[b[j]]++;
            }

            for(int j = 0; j < n; j++) {
                if(winCounts[i].id == j) {
                    continue;
                }
                if(tmpCount[j] == remain) {
                    result.add(Math.min(winCounts[i].id, j) + ", " + Math.max(winCounts[i].id, j));
                }
            }


        }

        System.out.println(result.size());

    }
}

class WinCount {
    int id;
    int count;

    WinCount(int id) {
        this.id = id;
    }
}