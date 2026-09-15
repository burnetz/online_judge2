
package atcoder.abc474;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] p = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();
        int[] query = Arrays.stream(new int[q]).map(e -> sc.nextInt()).toArray();

        Set<Integer> set = new HashSet<>();
        Deque<Integer> que = new ArrayDeque<>();

        for(int i = q - 1; i >= 0 ; i--) {
            if(!set.contains(query[i])) {
                set.add(query[i]);
                que.addFirst(query[i]);
            }
        }


        for(int i = 0; i < n; i++) {
            if(!set.contains(p[i])) {
                System.out.print(p[i] + " ");
            }
        }

        while(!que.isEmpty()) {
            System.out.print(que.poll() + " ");
        }
    }
}