package atcoder.abc428;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        String s = sc.next();

        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n - k + 1; i++) {
//            System.out.println(i);
            String sub = s.substring(i, i + k);
//            System.out.println("sub " + sub);

            map.merge(sub, 1, (n1, n2) -> n1 + 1);
            int tmp = map.get(sub);

            if(tmp > max) {
                max = tmp;
            }
        }

        Iterator<String> it = map.keySet().iterator();

        PriorityQueue<String> pq = new PriorityQueue<>();
        while(it.hasNext()) {
            String tmpS = it.next();
//            System.out.println("tmpS " + tmpS);

            if(map.get(tmpS) == max) {
                pq.add(tmpS);
            }
        }

        System.out.println(max);

        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }

    }
}