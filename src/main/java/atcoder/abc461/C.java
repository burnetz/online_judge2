package atcoder.abc461;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Jewel> que1 = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.value(), e1.value()));
        for(int i = 0; i < n; i++) {
            que1.add(new Jewel(sc.nextInt(), sc.nextInt()));
        }

        Set<Integer> set = new HashSet<>();

        Queue<Jewel> que2 = new ArrayDeque<>();

        long result = 0;
        while(set.size() < m) {
            Jewel tmp = que1.poll();

            if(set.contains(tmp.color())) {
                que2.add(tmp);
            }
            else {
                set.add(tmp.color());
                result += tmp.value();
            }
        }

        while(!que2.isEmpty()) {
            que1.add(que2.remove());
        }

        int remain = k - m;
        while (remain > 0) {
            Jewel tmp = que1.poll();
            result += tmp.value();
            remain--;
        }

        System.out.println(result);
    }
}

record Jewel(int color, int value) {}