package atcoder.arc170;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int INF = 1_000_000;
        //rightNearestPos[i][j] : 数字jが現れるインデックスでi以上かつ最小のもの
        int rightNearestPos[][] = new int[n + 2][11];
        for(int i = 0; i < n + 1 ; i++) {
            Arrays.fill(rightNearestPos[i], INF);
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= 10; j++) {
                rightNearestPos[i][j] = rightNearestPos[i + 1][j];
            }
            rightNearestPos[i][a[i]] = i;
        }

        long result = 0;

        //条件を満たす組を探すのは難しいので
        //「この区間内には等差数列が存在しない」という組の数を求める。
        //3🔫重ループだが等差数列としてありえる初項と公差の組み合わせは限られているので間に合う。
        for(int i = 0; i < n; i++) {
            int right = n;

            for(int j = 1; j <= 10; j++) {
                int firstPos = rightNearestPos[i][j];
                if(firstPos == INF) {
                    continue;
                }

                for(int k = -4; k <= 4; k++) {
                    if(j + 2*k <= 0 || j + 2*k > 10) {
                        continue;
                    }

                    int midPos = rightNearestPos[firstPos + 1][j + k];
                    if(midPos == INF) {
                        continue;
                    }
                    int rightPos = rightNearestPos[midPos + 1][j + 2*k];

                    right = Math.min(rightPos, right);
                }
            }

            //(i, i)のような組み合わせは含めない。
            result += Math.max(0, right - i - 1);
        }

        //すべての組み合わせからresultを引いたものが答え
        System.out.println((long)n * (n - 1) / 2 - result);
    }
}
