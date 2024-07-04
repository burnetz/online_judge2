package atcoder.abc360;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer>[] queues = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            queues[i] = new PriorityQueue<>();
        }

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int w[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            queues[a[i] - 1].add(w[i]);
        }

        int cost = 0;
        for(int i = 0; i < n; i++) {
            while(queues[i].size() > 1) {
                cost += queues[i].remove();
            }
        }

        System.out.println(cost);
    }
}