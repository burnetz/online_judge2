package atcoder.abc334;

import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long base = sc.nextLong();
        long interval = sc.nextLong();
        //modで考える上で、あらかじめ基準点を0に固定した方が分かりやすい。
        long left = sc.nextLong() - base;
        long right = sc.nextLong() - base;

        //leftより右（left含む）にある最初の木の位置を計算する
        long firstPos = left;
        if(left % interval != 0) {
            //Javaでは負の数のmodは負を返す。
            if(left < 0) {
                firstPos = left - left % interval;
            }
            else {
                firstPos = left + (interval - left % interval);
            }
        }
        //最初の木が区間からはみ出るなら区間内には1本もない
        if(firstPos > right) {
            System.out.println(0);
            return;
        }

        long lastPos = right;
        if(right % interval != 0) {
            if(right < 0) {
                lastPos = right - (interval + right % interval);
            }
            else {
                lastPos = right - right % interval;
            }
        }
        long result = (lastPos - firstPos) / interval + 1;

        System.out.println(result);


    }
}
