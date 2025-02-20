package atcoder.abc384;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();

        int p = sc.nextInt();
        int q = sc.nextInt();

        long matrix[][] = new long[h + 2][w + 2];

        for(int i = 0; i < h + 2; i++) {
            Arrays.fill(matrix[i], Long.MAX_VALUE);
        }

        for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }

        boolean visited[][] = new boolean[h + 2][w + 2];

        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        long currentPower = matrix[p][q];
        visited[p][q] = true;

        PriorityQueue<Slime> pq = new PriorityQueue<>((Comparator.comparingLong(o -> o.power)));

        pq.add(new Slime(q, p, 0));

        //基本的には隣接している中で最も弱いスライムの取り込みを試みれば良い。
        //最弱を後回しにした方が良いなどは特にない。
        while(!pq.isEmpty()) {
            Slime tmpSlime = pq.remove();
            //できれば掛け算で判定したかったがオーバーフローする。
            if(tmpSlime.power < currentPower / x) {
                currentPower += tmpSlime.power;
            }
            //以下ではなく未満なのでこの分岐が必要になる。1引いてもイコールなら条件を満たす。
            else if(tmpSlime.power == currentPower / x && tmpSlime.power == (currentPower - 1) / x) {
                currentPower += tmpSlime.power;
            }
            else {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int tmpX = tmpSlime.x + dx[i];
                int tmpY = tmpSlime.y + dy[i];

                if(!visited[tmpY][tmpX] && matrix[tmpY][tmpX] != Long.MAX_VALUE) {
                    pq.add(new Slime(tmpX, tmpY, matrix[tmpY][tmpX]));
                    visited[tmpY][tmpX] = true;
                }
            }
        }

        System.out.println(currentPower);
    }
}

class Slime {
    int x;
    int y;
    long power;


    public Slime(int x, int y, long power) {
        this.x = x;
        this.y = y;
        this.power = power;
    }
}