package atcoder.abc431;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int h[] = Arrays.stream(new int[n]).map(e -> sc.nextInt()).sorted().toArray();

        TreeMap<Integer, Integer> bodyMap = new TreeMap();
        for(int i = 0; i < m; i++) {
            int key = sc.nextInt();
            bodyMap.merge(key, 1, (e1, e2) -> e1 + 1);
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(bodyMap.higherKey(h[i] - 1) != null) {
                int key = bodyMap.higherKey(h[i] - 1);

                if(bodyMap.get(key) > 1) {
                    bodyMap.merge(key, 1, (e1, e2) -> e1 - 1);
                }
                else {
                    bodyMap.remove(key);
                }

                result++;
            }
        }

        if(result >= k) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}