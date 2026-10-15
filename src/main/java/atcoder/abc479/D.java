
package atcoder.abc479;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        long costL[] = new long[n];
        for(int i = 1; i < n; i++) {
            costL[i] = sc.nextLong();
        }
        long costR[] = new long[n];
        for(int i = 0; i < n - 1; i++) {
            costR[i] = sc.nextLong();
        }

        long INF = 1_000_000_000_000_000L;
        //自分より前の範囲内で最も小さいcostLの値
        long minCostL[] = new long[n];
        minCostL[n - 1] = INF;
        for(int i = n - 2; i >= 0; i --) {
            minCostL[i] = Math.min(minCostL[i + 1], costL[i + 1]);
        }
        //自分より後ろの範囲内で最も小さいcostRの値
        long minCostR[] = new long[n];
        minCostR[0] = INF;
        for(int i = 1; i < n; i++) {
            minCostR[i] = Math.min(minCostR[i - 1], costR[i - 1]);
        }

        for(int i = 0; i < q; i++) {
            int s = sc.nextInt() - 1;
            int t = sc.nextInt() - 1;

            long result = 0;
            if(s < t) {
                //素直にsからtに直接移動するか、一旦左に移動してからtに移動するか。
                //それ以外の方法は最適になり得ないし、どこを経由するかを特定する必要もない。
                result = Math.min(costR[s], costL[s] + minCostR[s]);
            }
            else {
                result = Math.min(costL[s], costR[s] + minCostL[s]);
            }
            System.out.println(result);

        }
    }
}