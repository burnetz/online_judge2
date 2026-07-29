
package atcoder.abc467;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static void solve(Scanner sc) {
        long px = sc.nextLong();
        long py = sc.nextLong();
        long qx = sc.nextLong();
        long qy = sc.nextLong();
        long rx = sc.nextLong();
        long ry = sc.nextLong();
        long sx = sc.nextLong();
        long sy = sc.nextLong();

        //基本的な考え方としては「P,Qの二等分線」と「R,Sの二等分線」が交わるなら同心円を描ける。
        //ただし計算の都合上二等分線が垂直方向になるときは特別扱いする。
        if(py == qy) {
            if(ry == sy) {
                //各二等分線が平行でも、ちょうど重なる場合は同心円を描けるので注意。
                if(px + qx == rx + sx) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
            //計算するまでもなく平行ではないパターン
            else {
                System.out.println("Yes");
            }

        }
        else {
            //明らかに平行でないパターン
            if(ry == sy) {
                System.out.println("Yes");
            }
            else {
                //2直線の傾きを比較する際は積の形で比較すること。
                if((qx - px) * (sy - ry) == (sx - rx) * (qy - py)) {
                    //平行な2直線が完全に一致するかどうかを確認
                    if((py + qy - ry - sy) * (sy - ry) == - (sx - rx) * (px + qx - rx - sx)) {
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }
                }
                else {
                    System.out.println("Yes");
                }
            }
        }
    }
}