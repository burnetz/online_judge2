package atcoder.abc334;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] matrix = new char[h][w];
        groupId = new int[h][w];
        for(int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
            Arrays.fill(groupId[i], -1);
        }

        int mod = 998244353;

        int numOfGroups = 0;
        int red = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '.') {
                    red++;
                }
                else {
                    //いくつの緑の島があるかはDFSで数えられる。
                    if(groupId[i][j] == -1) {
                        dfs(matrix, h, w, j, i, numOfGroups++);
                    }
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        long expectSum = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(matrix[i][j] == '#') {
                    continue;
                }

                HashSet<Integer> set = new HashSet<>();
                for(int k = 0; k < 4; k++) {
                    int tmpX = j + dx[k];
                    int tmpY = i + dy[k];

                    if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == '#') {
                        set.add(groupId[tmpY][tmpX]);
                    }
                }
                //赤いマスの周囲にいくつのグループがあるかによって
                //緑への変更時にいくつグループが減るかわかる。
                expectSum += numOfGroups - (set.size() - 1);
                expectSum %= mod;
            }
        }

        //逆数を求めるということは red^x ≡ 1(mod p)となるxを求めるということ。
        //フェルマーの小定理より red^(p - 1) ≡ 1(mod p)なので x ≡ red^(p - 2)
        //ただしこの計算は高速に累乗を求める方法が必要。
        long divisor = repeatablePow(red, mod - 2, mod);

        System.out.println(expectSum * divisor % mod);
    }

    static int groupId[][];

    static void dfs(char matrix[][], int h, int w, int x, int y, int gid) {
        groupId[y][x] = gid;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && matrix[tmpY][tmpX] == '#' && groupId[tmpY][tmpX] == -1) {
                dfs(matrix, h, w, tmpX, tmpY, gid);
            }
        }
    }

    static long repeatablePow(int x, int n, int mod){
        if(n == 0){
            return 1;
        }
        long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
        if(n % 2 == 1){
            result = result*x%mod;
        }
        return result;
    }
}


