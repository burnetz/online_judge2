package atcoder.abc461;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        char[][] matrix = new char[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int count[][] = new int[h + 1][w + 1];

        //任意の長方形区間に含まれる1の数を集計するための準備
        for(int i = 0; i < h ; i++) {
            for(int j = 0; j < w; j++) {
                count[i + 1][j + 1] = count[i][j + 1] + count[i + 1][j] - count[i][j];

                if(matrix[i][j] == '1') {
                    count[i + 1][j + 1]++;
                }
            }
        }

        long result = 0;
        //2次元のまま考えるのは難しいので、まず上端と下端を固定する。
        for(int u = 0; u < h; u++) {
            for (int b = u + 1; b <= h; b++) {
                Map<Integer, Integer> map = new HashMap<>();

                //累積和を記録し（現在の累積和）-Kの登場回数を参照することで計算可能
                for(int i = 0; i <= w; i++) {
                    int tmp = count[b][i] - count[u][i];

                    if(map.containsKey(tmp - k)) {
                        result += map.get(tmp - k);
                    }

                    map.merge(tmp, 1, (e1, e2) -> e1 + 1);
                }
            }
        }

        System.out.println(result);
    }

}