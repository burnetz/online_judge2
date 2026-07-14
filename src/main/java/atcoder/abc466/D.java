
package atcoder.abc466;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        //行ごと、列ごとのタイムスタンプ記録用
        Vector<Integer>[] vectorsR = new Vector[n];
        Vector<Integer>[] vectorsC = new Vector[n];

        for(int i = 0; i < n; i++) {
            vectorsR[i] = new Vector<>();
            vectorsC[i] = new Vector<>();
        }

        int r[] = new int[m];
        int c[] = new int[m];

        for(int i = 0; i < m; i++) {
            r[i] = sc.nextInt() - 1;
            c[i] = sc.nextInt() - 1;

            vectorsR[r[i]].add(i);
            vectorsC[c[i]].add(i);
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            //このサーチは必ずヒットするのでインデックスの反転等は不要
            int indexR = Collections.binarySearch(vectorsR[r[i]], i);
            int indexC = Collections.binarySearch(vectorsC[c[i]], i);

            //もしもそのコマが残っているなら、自身が配置された時刻より後に行削除もしくは列削除が行われていない。
            if(indexR == vectorsR[r[i]].size() - 1 && indexC == vectorsC[c[i]].size() - 1) {
                count++;
            }
        }

        System.out.println(count);

    }
}