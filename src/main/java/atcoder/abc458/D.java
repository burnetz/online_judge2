package atcoder.abc458;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int q = sc.nextInt();

        //pqLの先頭が配列全体の中央値という状態を常に維持する。
        PriorityQueue<Integer> pqL = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        PriorityQueue<Integer> pqR = new PriorityQueue<>(Integer::compareTo);
        pqL.add(x);

        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            pqL.add(a);
            pqL.add(b);
            pqR.add(pqL.remove());

            //上の時点で要素数については条件を満たすが、更に1回スワップを要する状況がある。
            if(pqL.peek() > pqR.peek()) {
                int tmp = pqL.poll();
                pqL.add(pqR.poll());
                pqR.add(tmp);
            }

            System.out.println(pqL.peek());
        }

    }
}