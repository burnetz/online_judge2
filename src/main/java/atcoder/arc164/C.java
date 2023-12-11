package atcoder.arc164;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Card[] card = new Card[n];

        for(int i = 0; i < n; i++) {
            card[i] = new Card(sc.nextInt(), sc.nextInt());
        }

        //初期の表と裏の差でソートする。
        //前に来るほど「できれば裏の状態で取った方がよい」ということ。
        Arrays.sort(card);

        //表と裏について累積和を求める。
        long sumA[] = new long[n + 1];
        long sumB[] = new long[n + 1];

        for(int i = 0; i < n; i++) {
            sumA[i + 1] = card[i].a + sumA[i];
            sumB[i + 1] = card[i].b + sumB[i];
        }

        //まず、Aliceがどのように行動しても結果は変わらない。
        //Bobが各カードについて表裏のどちらを取るかを決め
        //取りたいカードの中で表を向いているものを順に取り尽くせば
        //あとはAliceが裏返すのを待って順に取れば良いため。

        //ただしAliceの操作の回数がちょうどN回と決まっている以上
        //偶置換に相当するパターンしか実現できない。
        long result = Long.MIN_VALUE;
        for(int i = n ; i >= 0; i -= 2) {
            long tmp = sumB[i] + sumA[n] - sumA[i];
            result = Math.max(result, tmp);
        }

        System.out.println(result);
    }
}

class Card implements Comparable<Card> {
    int a;
    int b;

    Card (int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.a - this.b, o.a - o.b);
    }
}