package atcoder.abc463;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Pair[] pairs = new Pair[n];
        double[] right = new double[n];

        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
            right[i] = pairs[i].right();
        }

        //右端の座標について昇順で並べる。
        Arrays.sort(pairs, Comparator.comparingDouble(Pair::right));
        //あとでバイナリサーチに使う用。上の配列と順番が対応している。
        Arrays.sort(right);

        int l = 0;
        int r = 1_000_000_001;
        //mid以上の間隔を保ったままk枚以上の布を選べるか調べ、二部探索で解を絞る。
        while(r - l > 1) {
            int mid = (l + r) / 2;

            //dp[i] : i番目まで見た時、mid以上の間隔を空けて選べる布の枚数の最大値
            int dp[] = new int[n];
            dp[0] = 1;

            boolean isOK = false;
            for (int i = 1; i < n; i++) {
                //i番目を選ばないパターン
                dp[i] = dp[i - 1];

                int tmp = (int)pairs[i].left() - mid;

                //わざと外すようにしているのでインデックスを調整する。
                int tmpIndex = Arrays.binarySearch(right, tmp + 0.5);
                tmpIndex++;
                tmpIndex *= -1;

                if(tmpIndex >= 1) {
                    //なお、dp[tmpIndex - 1]においてtmpIndex - 1枚目の布が選ばれているかは不明だが問題は無い。
                    dp[i] = Math.max(dp[i], dp[tmpIndex - 1] + 1);
                }

                //k枚選べることが確定した時点でbreakしないとTLEになる。
                if(dp[i] >= k) {
                    isOK = true;
                    break;
                }
            }

            if(isOK) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        if(l == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(l);
        }


    }
}

record Pair (double left, double right) {}