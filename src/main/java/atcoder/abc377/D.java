package atcoder.abc377;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Range[] ranges = new Range[n];
        for(int i = 0; i < n; i++) {
            ranges[i] = new Range(sc.nextInt(), sc.nextInt());
        }

        //各区間を右端について昇順に並べる。
        PriorityQueue<Range> pq = new PriorityQueue<>();
        Arrays.stream(ranges).forEach(e -> pq.add(e));
        int limit = pq.peek().right;

        long result = 0;
        for(int i = 1; i <= m; i++) {
            //ここで消去されるのは左端がiより小さくなったことで覆わないことが確定した区間。
            //本当はキューの中にまだ消せる区間が残っているかもしれないが
            //答えに影響するのは先頭の要素（つまりキュー内で最も右端がiに近い）のみ。
            while(!pq.isEmpty() && pq.peek().left < i) {
                pq.remove();
            }

            //残っている区間のうち最も違い右端に着目して計算する。
            if(pq.isEmpty()) {
                limit = m + 1;
            }
            else {
                limit = pq.peek().right;
            }

            int tmp = limit - i;
            result += tmp;
        }

        System.out.println(result);

    }
}

class Range implements Comparable<Range> {
    int left;
    int right;

    Range(int left, int right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public int compareTo(Range o) {
        return Integer.compare(this.right, o.right);
    }
}