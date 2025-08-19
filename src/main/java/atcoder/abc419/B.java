package atcoder.abc419;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    int x = sc.nextInt();

                    pq.add(x);
                }
                case 2 -> {
                    System.out.println(pq.remove());
                }
            }
        }
    }
}