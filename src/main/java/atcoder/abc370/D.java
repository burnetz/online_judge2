package atcoder.abc370;

import java.util.Scanner;
import java.util.TreeSet;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int q = sc.nextInt();

        //ある座標よりもギリギリ小さい値（大きい値）を探すのにtreesetが便利。
        //マスの合計は多くないので縦横同時にtreesetで管理できる。
        TreeSet<Integer>[] setsC = new TreeSet[w];
        TreeSet<Integer>[] setsR = new TreeSet[h];

        for(int i = 0; i < h; i++) {
            setsR[i] = new TreeSet<>();
        }

        for(int i = 0; i < w; i++) {
            setsC[i] = new TreeSet<>();
        }

        //最初は全てのマスに壁が存在する。
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                setsR[i].add(j);
                setsC[j].add(i);
            }
        }

        for(int i = 0; i < q; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;

            //入力された座標に壁があるならこれだけ
            if(setsR[y].contains(x)) {
                setsR[y].remove(x);
                setsC[x].remove(y);
            }
            //壁がない場合は４方向について処理を行う。O(log H)あるいはO(log W)で済む。
            else {
                //left
                Integer leftX = setsR[y].lower(x);
                if(leftX != null) {
                    removeWall(leftX, y, setsR, setsC);
                }
                //right
                Integer rightX = setsR[y].higher(x);
                if(rightX != null) {
                    removeWall(rightX, y, setsR, setsC);
                }
                //up
                Integer upY = setsC[x].lower(y);
                if(upY != null) {
                    removeWall(x, upY, setsR, setsC);
                }
                //down
                Integer downY = setsC[x].higher(y);
                if(downY != null) {
                    removeWall(x, downY, setsR, setsC);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < h; i++) {
            result += setsR[i].size();
        }

        System.out.println(result);
    }

    static void removeWall(int x, int y, TreeSet<Integer>[] setsR, TreeSet<Integer>[] setsC) {
        setsR[y].remove(x);
        setsC[x].remove(y);
    }
}