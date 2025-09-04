package atcoder.abc376;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
            int b[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

            Pair[] pairs = new Pair[n + 1];

            for(int j = 0; j < n; j++) {
                pairs[j] = new Pair(a[j], b[j]);
            }
            int INF = 9_999_999;
            pairs[n] = new Pair(INF, 0);

            Arrays.sort(pairs, (e1, e2) -> e1.a != e2.a ? Integer.compare(e1.a, e2.a) : Integer.compare(e2.b, e1.b));

            long tmpSum = 0;
            long result = Long.MAX_VALUE;

            PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.b, e1.b));
            for(int j = 0; j < n; j++) {
                //max(A_i)の値ごとに更新を行う。pairs[j]はaの値がmax(A_i)と等しい要素の中で最もbが小さいので特別扱いする。
                if(pairs[j].a != pairs[j + 1].a) {
                    //特別扱いされた要素以外はaに関係なくbの値基準でk-1個だけ選ばれるようにする。
                    while (pq.size() > k - 1) {
                        Pair tmpPair = pq.remove();
                        tmpSum -= tmpPair.b;
                    }

                    //そもそも要素が足りない場合は何もしない。
                    if (pq.size() == k - 1) {
                        result = Math.min(result, (tmpSum + pairs[j].b) * pairs[j].a);
                    }
                }
                pq.add(pairs[j]);
                tmpSum += pairs[j].b;
            }

            System.out.println(result);
        }
    }
}

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}