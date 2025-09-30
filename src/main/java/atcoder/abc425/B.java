package atcoder.abc425;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count[] = new int[n + 1];

        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        for(int i = 0; i < n; i++) {
            if(a[i] == -1) {
                continue;
            }
            if(count[a[i]] >= 1) {
                System.out.println("No");
                return;
            }
            count[a[i]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                pq.add(i);
            }
        }

        System.out.println("Yes");
        for (int i = 0; i < n; i++) {
            if(a[i] != -1) {
                System.out.print(a[i] + " ");
            }
            else {
                System.out.print(pq.remove() + " ");
            }
        }



    }
}