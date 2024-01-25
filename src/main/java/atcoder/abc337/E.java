package atcoder.abc337;

import java.util.Scanner;
import java.util.Vector;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //それぞれのジュースの番号を2進数で表したとして
        //各桁を担当する友人がいれば良いのでlog_2(n)人で足りる。
        int m = (int)Math.ceil((Math.log(n) / Math.log(2)));

        Vector<Integer>[] friends = new Vector[m];
        for(int i = 0; i < m; i++) {
            friends[i] = new Vector<>();
        }

        //ジュースの番号（0オリジン）を2進数で表したときに
        //自分の担当する桁が1となるジュースを全て飲ませる。
        for(int i = 0; i < n; i++) {
            int mask = 1;
            for(int j = 0; j < m; j++) {
                if((mask & i) != 0) {
                    //友人を逆順にしておくと最終的な答えの出力が楽になる。
                    friends[m - j - 1].add(i + 1);
                }
                mask <<= 1;
            }
        }

        System.out.println(m);
        for(int i = 0; i < m; i++) {
            System.out.print(friends[i].size() + " ");
            for(int j = 0; j < friends[i].size(); j++) {
                System.out.print(friends[i].get(j) + " ");
            }
            System.out.println();
        }

        String answerStr = sc.next();

        //誰がお腹を壊したかがそのまま2進数での答えになっている（ただし1ずらす）
        int result = Integer.parseInt(answerStr, 2) + 1;

        System.out.println(result);
    }
}
