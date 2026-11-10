
package atcoder.abc483;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] vote1 = new int[n];
        int topIndex = 0;

        //第1希望の候補者ごとに、第2希望は誰を選んだかを記録しておく。
        Vector<Integer>[] secondVotes = new Vector[n];
        for(int i = 0; i < n; i++) {
            secondVotes[i] = new Vector<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            vote1[a]++;
            secondVotes[a].add(b);
        }

        for(int i = 0; i < n; i++) {
            if(vote1[topIndex] < vote1[i]) {
                topIndex = i;
            }
        }

        for(int i = 0; i < n; i++) {
            //当初の得票数2位以降を把握するのが面倒なのでトップが辞退するパターンについては個別に処理する。
            //ここだけでO(N)かかるが一度しか発生しないので問題ない。
            if(i == topIndex) {
                int[] vote1Copy = Arrays.copyOf(vote1, n);
                vote1Copy[topIndex] = 0;
                for(int j = 0; j < secondVotes[i].size(); j++) {
                    vote1Copy[secondVotes[i].get(j)]++;
                }

                int topIndex2 = 0;
                for(int j = 0; j < n; j++) {
                    if(vote1Copy[topIndex2] < vote1Copy[j]) {
                        topIndex2 = j;
                    }
                }

                System.out.println(topIndex2 + 1);
            }
            //一見ここだけでO(N)かかるが、投票自体全部で2M回しか番号を書けないので十分間に合う。
            else {
                Map<Integer, Integer> map = new HashMap<>();
                for(int j = 0; j < secondVotes[i].size(); j++) {
                    map.merge(secondVotes[i].get(j), 1, (e1, e2) -> e1 + 1);
                }

                Iterator<Integer> it = map.keySet().iterator();
                int topIndex2 = topIndex;
                //現時点でのトップは既に把握しており、逆転の可能性のみをチェックする。
                while(it.hasNext()) {
                    int id = it.next();
                    int tmpVote = vote1[id] + map.get(id);
                    //トップ候補にも追加の票があることに注意
                    int topScore = vote1[topIndex2];
                    if(map.get(topIndex2) != null) {
                        topScore += map.get(topIndex2);
                    }

                    if(topScore < tmpVote) {
                        topIndex2 = id;
                    }
                    else if(topScore == tmpVote && topIndex2 > id) {
                        topIndex2 = id;
                    }
                }

                System.out.println(topIndex2 + 1);

            }
        }

    }
}