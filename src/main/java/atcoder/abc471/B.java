
package atcoder.abc471;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for(int i = 0; i < n; i++) {
            String str = sc.next().toLowerCase();

            map.merge(str, 1, (e1, e2) -> e1 + 1);

            result = Math.max(result, map.get(str));
        }

        System.out.println(result);
    }
}