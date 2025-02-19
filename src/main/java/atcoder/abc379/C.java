package atcoder.abc379;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //値が非常に大きいので各所でオーバーフロー注意
        int n = sc.nextInt();
        int m = sc.nextInt();

        Box[] boxes = new Box[m + 1];

        int x[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();
        int a[] = Arrays.stream(new int[m]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < m; i++) {
            boxes[i] = new Box(x[i], a[i]);
        }
        boxes[m] = new Box(n + 1, 0);

        Arrays.sort(boxes);

        //一方向にしか動かせないので、最初の箱が1になかったら不可能
        if(boxes[0].position != 1) {
            System.out.println(-1);
            return;
        }

        long result = 0;
        for(int i = 0; i < m; i++) {
            //どの箱も中身を1個にしなければならないので
            //必要分に加え余剰分も移動させる。
            int remain = boxes[i].numOfStones - 1;
            int require = boxes[i + 1].position - boxes[i].position - 1;

            //次の箱までを埋められないパターン
            if(remain < require) {
                System.out.println(-1);
                return;
            }

            //必要分についての計算
            result += sumSteps(1, require);

            //余剰分がある場合の計算
            if(remain > require) {
                int extra = remain - require;
                result += (long)extra * (require + 1);
                boxes[i + 1].numOfStones += extra;
            }
        }

        if(boxes[m].numOfStones > 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    //公差1の等差数列の和
    static long sumSteps(int from, int to) {
        return ((long)to + from) * (to - from + 1) / 2;
    }
}

class Box implements Comparable<Box> {
    int position;
    int numOfStones;

    Box(int position, int numOfStones) {
        this.position = position;
        this.numOfStones = numOfStones;
    }


    @Override
    public int compareTo(Box o) {
        return Integer.compare(this.position, o.position);
    }
}