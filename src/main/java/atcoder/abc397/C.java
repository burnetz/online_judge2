package atcoder.abc397;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.merge(a[i], 1, (n1, n2) -> n1 + 1);
        }

        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            set.add(a[i]);
            if(map.get(a[i]) == 1) {
                map.remove(a[i]);
            }
            else {
                map.put(a[i], map.get(a[i]) - 1);
            }

            result = Math.max(result, set.size() + map.size());
        }

        System.out.println(result);
    }
}