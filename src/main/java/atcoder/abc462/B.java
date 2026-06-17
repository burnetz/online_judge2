package atcoder.abc462;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer>[] queues = new PriorityQueue[n];

        for(int i = 0; i < n; i++) {
            queues[i] = new PriorityQueue<>();
        }

        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for(int j = 0; j < k; j++) {
                int a = sc.nextInt() - 1;
                queues[a].add(i);
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(queues[i].size() + " ");
            while(!queues[i].isEmpty()) {
                System.out.print((queues[i].remove() + 1) + " ");
            }
            System.out.println();
        }


    }
}