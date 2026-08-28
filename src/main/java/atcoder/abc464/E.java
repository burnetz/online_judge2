
package atcoder.abc464;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int q = sc.nextInt();

        Query[] queries = new Query[q];
        for(int i = 0; i < q; i++) {
            queries[i] = new Query(sc.nextInt(), sc.nextInt(), sc.next());
        }

        //各行における左端
        int[] l = new int[h];
        //各列における上端（なおあまり活用していない）
        int[] t = new int[w];
        String[][] matrix = new String[h][w];

        //後で塗りつぶされる箇所については考える必要がないため
        //クエリを逆順で処理した方が効率よく解ける。
        for(int i = q - 1; i >= 0; i--) {
            for(int j = t[w - 1]; j < queries[i].r(); j++) {
                for(int k = l[j]; k < queries[i].c(); k++) {
                    matrix[j][k] = queries[i].x();

                    //列単位での効率化に関する処理だが、実際にはt[w-1]（一番右）しか使っていない。
                    //それだけでも十分高速化できる。
                    t[k] = Math.max(t[k], queries[i].r());
                }
                //行単位で見たとき、ここで塗りつぶした範囲は以後見る必要がない。
                l[j] = Math.max(l[j], queries[i].c());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] != null ) {
                    sb.append(matrix[i][j]);
                }
                else {
                    sb.append("A");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

record Query(int r, int c, String x) {}