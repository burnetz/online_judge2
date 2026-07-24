package atcoder.abc434;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cloud[] clouds = new Cloud[n];

        int[][] matrix = new int[2001][2001];

        for(int i = 0; i < n; i++) {
            clouds[i] = new Cloud(sc.nextInt() - 1, sc.nextInt(), sc.nextInt() - 1, sc.nextInt());

            //長方形の四隅（左上以外はギリギリ範囲外）に1もしくは-1を割り当てることで後続のステップが楽になる。
            matrix[clouds[i].u][clouds[i].l]++;
            matrix[clouds[i].d][clouds[i].l]--;
            matrix[clouds[i].u][clouds[i].r]--;
            matrix[clouds[i].d][clouds[i].r]++;
        }

        //このループによりmatrix[i][j]がいくつの長方形に覆われているかを導出できる。
        for(int i = 0; i <= 2000; i++) {
            for(int j = 0; j <= 2000; j++) {
                if(j > 0) {
                    matrix[i][j] += matrix[i][j - 1];
                }
                if(i > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
                if(i > 0 && j > 0) {
                    matrix[i][j] -= matrix[i - 1][j - 1];
                }
            }
        }

        //もともと青空であるマスを数える。
        int count0 = 0;
        int[][] count1 = new int[2001][2001];
        for(int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                if (matrix[i][j] == 0) {
                    count0++;
                }
            }
        }

        //count[i + 1][j + 1]は(0,0)から(i,j)までに登場する1の個数を保持する。
        for(int i = 0; i < 2000; i++) {
            for(int j = 0; j < 2000; j++) {
                if(matrix[i][j] == 1) {
                    count1[i + 1][j + 1]++;
                }
                count1[i + 1][j + 1] += count1[i][j + 1];
                count1[i + 1][j + 1] += count1[i + 1][j];
                count1[i + 1][j + 1] -= count1[i][j];
            }
        }

        //0の個数および特定エリア内の1の個数の和が求める答え
        for(int i = 0; i < n; i++) {
            int thin = 0;

            thin = count1[clouds[i].d][clouds[i].r] - count1[clouds[i].d][clouds[i].l] - count1[clouds[i].u][clouds[i].r] + count1[clouds[i].u][clouds[i].l];

            System.out.println(count0 + thin);
        }
    }
}

class Cloud {
    int u, d, l, r;

    Cloud(int u, int d, int l, int r) {
        this.u = u;
        this.d = d;
        this.l = l;
        this.r = r;
    }
}
