package atcoder.abc308;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String input = sc.next();
            map.merge(input, 1, (n1, n2) -> n1 + 1);
        }

        String colors[] = new String[m + 1];
        colors[0] = "DEFAULT";
        for(int i = 0; i < m ; i++){
            colors[i + 1] = sc.next();
        }

        for(int i = 0; i < m + 1; i++){
            mapPrice.put(colors[i], sc.nextInt());
        }

        map.forEach((key, val) -> {
            total += val * mapPrice.getOrDefault(key, mapPrice.get("DEFAULT"));
        });

        System.out.println(total);
    }
    static long total;
    static Map<String, Integer> mapPrice = new HashMap<>();
}
