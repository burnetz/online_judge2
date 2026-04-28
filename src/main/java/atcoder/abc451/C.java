package atcoder.abc451;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < q; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    pq.add(sc.nextInt());
                }
                case 2 -> {
                    int h = sc.nextInt();

                    while(!pq.isEmpty()) {
                        int tmp = pq.peek();

                        if(tmp <= h) {
                            pq.remove();
                        }
                        else {
                            break;
                        }
                    }
                }
            }

            System.out.println(pq.size());
        }
    }
}