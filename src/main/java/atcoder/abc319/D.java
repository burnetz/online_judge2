package atcoder.abc319;

import java.util.HashMap;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //最低限必要な横幅を2分探索で求める
        long left = 0;
        long right = 1_000_000_000_000_000L;
        while (left + 1 < right) {
            long mid = (left + right) / 2;

            int line = 1;
            long tmpSum = 0;
            for(int i = 0; i < n; i++) {
                //横幅より長い単語が1つでもある場合は行数が無限という扱い
                if(a[i] > mid) {
                    line = Integer.MAX_VALUE;
                    break;
                }

                //行頭以外は空白が1つずつ必要
                int padding = tmpSum == 0 ? 0 : 1;

                if(tmpSum + padding + a[i] > mid) {
                    line++;
                    tmpSum = a[i];
                }
                else {
                    tmpSum += padding + a[i];
                }
            }

            if(line <= m) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        System.out.println(right);
    }
}
