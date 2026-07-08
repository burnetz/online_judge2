
package atcoder.abc465;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        Deque<Integer> deque = new ArrayDeque<>();
        boolean reverse = false;
        //区間全体を反転するのではなく、状況に応じて先頭と末尾どちらに追加するかを変える。
        for(int i = 0; i < n; i++) {
            if (reverse) {
                deque.addFirst(i + 1);
            } else {
                deque.addLast(i + 1);
            }

            if (s.charAt(i) == 'o') {
                reverse = !reverse;
            }
        }

        for(int i = 0; i < n; i++) {
            int tmp = 0;
            if (reverse) {
                tmp = deque.removeLast();
            }
            else {
                tmp = deque.removeFirst();
            }
            System.out.print(tmp + " ");
        }

    }
}