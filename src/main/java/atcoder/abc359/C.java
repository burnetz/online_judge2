package atcoder.abc359;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long startX = sc.nextLong();
        long startY = sc.nextLong();
        long goalX = sc.nextLong();
        long goalY = sc.nextLong();

        //安易に変えて良いものと駄目なものがある。
        //例えばスタート地点が(0,0)になるような平行移動はしてはいけない。

        //スタートの方が必ず左に来るよう入れ替える。
        //スタートとゴールの入れ替えは可能。
        if(startX > goalX) {
            long tmp = startX;
            startX = goalX;
            goalX = tmp;

            tmp = startY;
            startY = goalY;
            goalY = tmp;
        }

        long height = Math.abs(startY - goalY);
        long rightLimit;
        //スタート地点の座標によって右に行ける限度が変わる。
        //上に移動するのと右上に移動するのでコストが変わらないことを使う。
        if(isRight(startX, startY)) {
            rightLimit = startX + height;
        }
        else {
            rightLimit = startX + height + 1;
        }

        //上下移動のためにこのコストは必ずかかる。
        long result = height;


        if(goalX > rightLimit) {
            //計算しやすいよう座標をレンガ内右側に統一する。
            if(!isRight(goalX, goalY)) {
                goalX++;
            }
            result += (goalX - rightLimit) / 2;
        }

        System.out.println(result);
    }

    static boolean isRight(long x, long y) {
        return (x + y) % 2 == 1;
    }
}