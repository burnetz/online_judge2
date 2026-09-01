package atcoder.arc220;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        //N=2,3,5は不可能
        ngSet.add(2);
        ngSet.add(3);
        ngSet.add(5);

        for(int i = 0; i < t; i++) {
            solve(sc);
        }
    }

    static Set<Integer> ngSet = new HashSet<>();
    static final int LIMIT = 1_000_000;

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        if(ngSet.contains(n)) {
            System.out.println("No");
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //（解答を読んだ箇所）mod 3の値が0もしくは2になる場合のベースの配列が難しい。
        switch (n % 3) {
            case 0 -> {
                pq.add(2);pq.add(2);pq.add(2);pq.add(3);pq.add(3);pq.add(6);
            }
            case 1 -> {
                pq.add(1);
            }
            //一応、1/4=1/9+1/9+36/1に気づけばcase 0の場合のベース配列から作れなくもない。
            case 2 -> {
                pq.add(2);pq.add(2);pq.add(3);pq.add(3);pq.add(3);pq.add(3);pq.add(6);pq.add(6);
            }
        }

        //いずれのパターンであっても、要素を1つ取り出し2倍してから4回addすることで合計を変えることなく要素を3つ増やせる。
        while(pq.size() != n) {
            int tmp = pq.remove();

            for(int i = 0; i < 4; i++) {
                pq.add(tmp * 2);
            }
        }

        System.out.println("Yes");
        while(!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }


}
