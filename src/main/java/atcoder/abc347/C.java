package atcoder.abc347;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();

        //あらかじめa+bのmodをとる。曜日の情報は失われない。
        //また、ここでソートもしておく。
        long d[] = Arrays.stream(new long[n]).map(e -> sc.nextInt() % (a + b)).sorted().toArray();

        Deque<Long> deq = new ArrayDeque<>();
        Arrays.stream(d).forEach(e -> deq.addLast(e));

        //先頭の曜日から末尾の曜日までがすべて休日の日数に収まる可能性があるかを調べる。
        //それを先頭の場所を変えつつnパターン試す。
        //dequeなので高速にスライドできる。
        for(int i = 0; i < n; i++) {
            if(deq.getLast() - deq.getFirst() < a) {
                System.out.println("Yes");
                return;
            }
            //1週間加算した日数を末尾に加える。
            deq.addLast(deq.removeFirst() + a + b);
        }

        System.out.println("No");
    }
}