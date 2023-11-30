package atcoder.abc297;

import java.util.*;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        //昇順に並べるとTLEが発生しなくなったが
        //ここでソートをすること自体若干嘘解法っぽさがある。
        long a[] = Arrays.stream(new long[n]).map(e -> sc.nextLong()).sorted().toArray();

        //dp[i][j]: i番目までの数字を使えるときのj番目の合計金額
        long dp[][] = new long[n][k + 1];

        //1種類だけなら単純に倍数
        for(int i = 1; i <= k; i++) {
            dp[0][i] = a[0]*i;
        }

        for(int i = 1; i < n; i++) {

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j = 1; j <= k; j++) {
                pq.add(dp[i - 1][j]);
            }

            Vector<Long> vec = new Vector<>();
            vec.add(0L);
            //既存のdp[i - 1]の結果に対して新たに作れる数字を挿入したものがdp[i]になる。
            while(!pq.isEmpty() && vec.size() <= k) {
                long ceil = pq.remove();
                //これより小さい値はa[i]を足しても挿入する区間内の値にならない。
                long rangeBottom = vec.lastElement() - a[i];

                int index = Collections.binarySearch(vec, rangeBottom);
                if(index < 0) {
                    index = -(index + 1) - 1;
                }

                //このループの間vecの中身は絶えず増えていく。
                //なおかつサイズがkになったからといって途中で止めると誤答になるので
                //最序盤でaをソートする必要がある。
                for(int j = index + 1; ; j++) {
                    long tmp = vec.get(j);

                    if(tmp + a[i] >= ceil) {
                        break;
                    }

                    vec.add(tmp + a[i]);
                }


                vec.add(ceil);
            }

            for(int j = 0; j <= k; j++) {
                dp[i][j] = vec.get(j);
            }
        }

        System.out.println(dp[n - 1][k]);
    }
}