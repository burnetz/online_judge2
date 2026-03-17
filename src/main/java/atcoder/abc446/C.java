package atcoder.abc446;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            solve(sc);
        }

    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] a = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] b = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        Deque<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < a[i]; j++) {
                que.add(i);
            }

            for(int j = 0; j < b[i]; j++) {
                que.removeFirst();
            }

            while(!que.isEmpty() && que.getFirst() <= i - d) {
                que.removeFirst();
            }
        }

        System.out.println(que.size());
    }
}
