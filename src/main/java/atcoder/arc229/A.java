package atcoder.arc229;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        //操作によってRの位置は変わらないので一旦AとCについてだけ考える。
        //AとCをそれぞれ25個ずつ使ってAAA...ACCC...Cのような文字列を作ると
        //結局Cを右から左に移動させる作業なので操作数最大の場合25*25=625回となる。
        //最終的な文字列の長さは常に99文字になる。
        int remain = 25 * 25 - x;
        int aRemain = 25;
        int cRemain = 25;
        Deque<Character> queue = new ArrayDeque<>();

        //ベースとなるAとCの列から操作回数を25回ずつ減らす場合はCを1つずつ左端に移せばよい。
        while(remain >= 25) {
            queue.addLast('C');
            cRemain--;
            remain -= 25;
        }

        //端数についてもCの場所を1つずつずらすことで調整可能。
        if(remain > 0) {
            for (int i = 0; i < 25 - remain; i++) {
                queue.addLast('A');
                aRemain--;
            }

            queue.addLast('C');
            cRemain--;

            while (aRemain > 0) {
                queue.addLast('A');
                aRemain--;
            }
        }
        else {
            while (aRemain > 0) {
                queue.addLast('A');
                aRemain--;
            }
        }

        while(cRemain > 0) {
            queue.addLast('C');
            cRemain--;
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.pollFirst();

            result.append(c);

            if(!queue.isEmpty()) {
                result.append('R');
            }
        }

        System.out.println(result);


    }
}