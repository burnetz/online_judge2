package atcoder.abc402;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < q; i++) {
            int mode = sc.nextInt();

            switch (mode) {
                case 1 -> {
                    deque.add(sc.nextInt());
                }
                case 2 -> {
                    System.out.println(deque.removeFirst());
                }
            }
        }
    }
}