package atcoder.abc358;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pqA.add(sc.nextInt());
        }

        for(int i = 0; i < m; i++) {
            pqB.add(sc.nextInt());
        }

        long result = 0;
        while(!pqB.isEmpty()) {
            if(pqA.isEmpty()) {
                System.out.println(-1);
                return;
            }

            if(pqA.peek() >= pqB.peek()) {
                result += pqA.poll();
                pqB.poll();
            }
            else {
                pqA.poll();
            }

        }

        System.out.println(result);

    }
}