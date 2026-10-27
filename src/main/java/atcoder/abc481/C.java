
package atcoder.abc481;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        int next = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < q; i++) {
            String name = sc.next();
            if(map.containsKey(name)) {
                System.out.println(map.get(name));
            }
            else {
                System.out.println(next);
                map.put(name, next++);
            }
        }
    }
}